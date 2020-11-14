package kr.or.ddit.post.dao;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.file.model.AttachFileVO;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.repl.model.ReplVO;

@Repository("postDao")
public class PostDao implements PostDaoI {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	

	@Override
	public List<PostVO> getPostList(Map<String, Object> map){
		return sqlSession.selectList("post.getPostList", map);
	}

	@Override
	public int getAllPostCnt(String boardid){
		return sqlSession.selectOne("post.getAllPostCnt", boardid);
	}

	@Override
	public String insertPost(PostVO postVo){
		sqlSession.insert("post.insertPost", postVo);
		String result = postVo.getPostid();
		return result;
	}
	
	
	
	@Override
	//쿼리문 수정 요망
	public int insertFile(List<AttachFileVO> fileList){
		int cnt = 0;
		cnt = sqlSession.insert("post.insertFile", fileList);
//		for(AttachFileVO file : fileList) {
//			cnt += sqlSession.insert("post.insertFile",file);
//		}
		System.out.println("dao-side-insertfile cnt : "+cnt);
		return cnt;
	}

	@Override
	public PostVO getPost(String postid){
		return sqlSession.selectOne("post.getPost", postid);
	}

	@Override
	public List<AttachFileVO> getFileList(String postid){
		return sqlSession.selectList("post.getFileList", postid); 
	}

	@Override
	public int updatePost(PostVO postVo){
		return sqlSession.update("post.updatePost", postVo);
	}

	@Override
	public int deletePost(String postid){
		return sqlSession.update("post.deletePost", postid);
	}

	@Override
	//insert 제대로 되면 그때 delete 다중쿼리문 수정 요망
	public int deleteFile(List<String> delList){
		int cnt = 0;
		for(String file : delList) {
			cnt += sqlSession.delete("post.deleteFile", file);			
		}
		return cnt;
	}

	@Override
	public List<ReplVO> getReplList(String postid){
		return sqlSession.selectList("post.getReplList", postid);
	}

}
