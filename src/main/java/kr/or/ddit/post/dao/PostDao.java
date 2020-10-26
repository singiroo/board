package kr.or.ddit.post.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.post.model.PostVO;

public class PostDao implements PostDaoI {

	@Override
	public List<PostVO> getPostList(SqlSession sqlSession, Map<String, Object> map) throws SQLException {
		return sqlSession.selectList("post.getPostList", map);
	}

	@Override
	public int getAllPostCnt(SqlSession sqlSession, String boardid) throws SQLException {
		return sqlSession.selectOne("post.getAllPostCnt", boardid);
	}

}
