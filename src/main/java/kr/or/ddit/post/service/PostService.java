package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.file.model.AttachFileVO;
import kr.or.ddit.post.dao.PostDaoI;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.repl.model.ReplVO;

@Service("postService")
public class PostService implements PostServiceI {
	
	@Resource(name = "postDao")
	private PostDaoI postDao;
	
	@Override
	public Map<String, Object> getPostListPage(Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//출력할 글 목록
		List<PostVO> postList = postDao.getPostList(map);
		//문자 가공
		for(PostVO post : postList) {
			post.setTitle(post.getTitle().replaceAll(" ", "&nbsp;"));
			if(("F").equals(post.getStatus())) {
				String oldTitle = post.getTitle();
				String newTitle = oldTitle.substring(0, oldTitle.lastIndexOf("─")+1);
				newTitle += "[삭제된 게시글입니다]";
				post.setTitle(newTitle);
			}
		}
		
		int allcnt = postDao.getAllPostCnt((String)map.get("boardid"));
		System.out.println("allcnt : "+allcnt);
		int totalPage = 1;	//출력할 전체 페이지수 기본값을 1로 설정
		totalPage = (int)(Math.ceil((double)allcnt / ((PageVO)map.get("page")).getPageSize())); 
		System.out.println("service-side totalPage : "+totalPage);
		resultMap.put("postList", postList);
		resultMap.put("totalPage", totalPage);			
		return resultMap;
	}

	@Override
	public int insertPost(Map<String, Object> map) {
		PostVO postVo = (PostVO)map.get("postVo");
		List<AttachFileVO> fileList = (List<AttachFileVO>)map.get("fileList");
		int cnt = 0;
		String postid = postDao.insertPost(postVo);
		if(!fileList.isEmpty()) {
			for(AttachFileVO file : fileList) {
				file.setPostid(postid);
			}
			cnt = postDao.insertFile(fileList);				
		}else {
			if(postid != null) {
				cnt = 1; // 게시글 등록이 1개 완료되었으므로
			}
		}
		return cnt;
	}

	@Override
	public Map<String, Object> getPost(String postid) {
		Map<String, Object> map = new HashMap<>();
		
		PostVO postVo = postDao.getPost(postid);
		List<AttachFileVO> fileList = postDao.getFileList(postid);
		List<ReplVO> replList = postDao.getReplList(postid);
		
		//map객체 생성하여 dao에서의 결과를 묶어야함.
		map.put("postVo", postVo);
		map.put("fileList", fileList);
		map.put("replList", replList);		
		
		return map;
	}

	@Override
	public int updatePost(Map<String, Object> map) {
	
		PostVO postVo = (PostVO)map.get("postVo");
		List<AttachFileVO> fileList = (List<AttachFileVO>) map.get("fileList");
		List<String> delList = (List<String>) map.get("delList");
		
		int cnt = 0;
		cnt = postDao.updatePost(postVo);
			
		cnt = postDao.insertFile(fileList);
		
		cnt = postDao.deleteFile(delList);				

		return cnt;
	}

	@Override
	public int deletePost(String postid) {
		return postDao.deletePost(postid);

	}

}
