package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.db.MybatisUtil;

public class BoardDao implements BoardDaoI {
	
	
	private SqlSession sqlSession;
	
	
	
	
	@Override
	public List<BoardVO> getBoardList(String userId) throws SQLException {
		sqlSession = MybatisUtil.getSqlSession();
		System.out.println("userId ::"+userId);
		List<BoardVO> boardList = null;
		boardList = sqlSession.selectList("board.getBoardList", userId);
		sqlSession.close();
		return boardList;
	}




	@Override
	public int insertBoard(BoardVO boardVo) throws SQLException {
		sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		cnt = sqlSession.insert("board.insertBoard", boardVo);
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}




	@Override
	public int updateBoard(BoardVO boardVo) throws SQLException {
		sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		cnt = sqlSession.update("board.updateBoard", boardVo);
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}




	@Override
	public List<BoardVO> getAllBoard() throws SQLException {
		sqlSession = MybatisUtil.getSqlSession();
		List<BoardVO> boardList = null;
		boardList = sqlSession.selectList("board.getAllBoard");
		sqlSession.close();
		return boardList;
	}

}
