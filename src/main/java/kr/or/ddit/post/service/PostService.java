package kr.or.ddit.post.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.file.model.AttachFileVO;
import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoI;
import kr.or.ddit.post.model.PostVO;

public class PostService implements PostServiceI {

	private PostDaoI postDao;
	private SqlSession sqlSession;
	
	@Override
	public Map<String, Object> getPostListPage(Map<String, Object> map) {
		postDao = new PostDao();
		sqlSession = MybatisUtil.getSqlSession();
		List<PostVO> postList = null;	//출력할 글 목록
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int totalPage = 1;	//출력할 전체 페이지수
		try {
			postList = postDao.getPostList(sqlSession, map);
			for(PostVO post : postList) {
				post.setTitle(post.getTitle().replaceAll(" ", "&nbsp;"));
			}
			int allcnt = postDao.getAllPostCnt(sqlSession, (String)map.get("boardid"));
			System.out.println("allcnt : "+allcnt);
//			totalPage = (int)Math.floor((double)postDao.getAllPostCnt(sqlSession, (String)map.get("boardid"))
//					/ ((PageVO)map.get("page")).getPageSize());
			totalPage = (int)(Math.ceil((double)allcnt / ((PageVO)map.get("page")).getPageSize())); 
			System.out.println("service-side totalPage : "+totalPage);
			resultMap.put("postList", postList);
			resultMap.put("totalPage", totalPage);			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		sqlSession.close();
		
		return resultMap;
	}

	@Override
	public int insertPost(Map<String, Object> map) {
		sqlSession = MybatisUtil.getSqlSession();
		postDao = new PostDao();
		PostVO postVo = (PostVO)map.get("postVo");
		List<AttachFileVO> fileList = (List<AttachFileVO>)map.get("fileList");
		String postid = null;
		int cnt = 0;
		try {
			postid = postDao.insertPost(sqlSession, postVo);
			if(!fileList.isEmpty()) {
				for(AttachFileVO file : fileList) {
					file.setPostid(postid);
				}
				cnt = postDao.insertFile(sqlSession, fileList);				
			}else {
				if(postid != null) {
					cnt = 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();				
			}
		}
		return cnt;
	}

	@Override
	public PostVO getPost(String postid) {
		postDao = new PostDao();
		
		PostVO postVo = null;
		try {
			postVo = postDao.getPost(postid);
			List<AttachFileVO> fileList = postDao.getFileList(postid);
			**
			//map객체 생성하여 dao에서의 결과를 묶어야함.
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return postVo;
	}

}
