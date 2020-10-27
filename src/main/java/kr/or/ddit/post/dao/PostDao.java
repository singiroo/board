package kr.or.ddit.post.dao;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.file.model.AttachFileVO;
import kr.or.ddit.post.model.PostVO;

public class PostDao implements PostDaoI {

	@Override
	public List<PostVO> getPostList(SqlSession sqlSession, Map<String, Object> map) throws SQLException {
		return sqlSession.selectList("post.getPostList", map);
	}

	@Override
	public int getAllPostCnt(SqlSession sqlSession, String boardid) throws SQLException {
		return (int)sqlSession.selectOne("post.getAllPostCnt", boardid);
	}

	@Override
	public String insertPost(SqlSession sqlSession, PostVO postVo) throws SQLException {
		int cnt = 0; 
		cnt = sqlSession.insert("post.insertPost", postVo);
		System.out.println("dao-side : "+postVo.getPostid());
		String result = null;
		if(cnt == 1) {
			result = postVo.getPostid();
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		return result;
	}
	
	
	
	@Override
	public int insertFile(SqlSession sqlSession, List<AttachFileVO> fileList) throws SQLException {
		
		int cnt = 0;
		for(AttachFileVO file : fileList) {
			cnt += sqlSession.insert("post.insertFile",file);
		}
	
		System.out.println("dao-side : "+cnt);
			
		if(cnt == fileList.size()) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		return cnt;
	}

	@Override
	public PostVO getPost(String postid) throws SQLException {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PostVO postVo = (PostVO)sqlSession.selectOne("post.getPost", postid);
		sqlSession.close();
		return postVo;
	}

	@Override
	public List<AttachFileVO> getFileList(String postid) throws SQLException {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<AttachFileVO> fileList = sqlSession.selectList("post.getFileList", postid); 
		return fileList;
	}

}
