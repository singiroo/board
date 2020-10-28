package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.model.BoardVO;

public class BoardService implements BoardServiceI{
	
	private BoardDaoI boardDao;
	
	
	
	
	@Override
	public List<BoardVO> getBoardList(String userId) {
		boardDao = new BoardDao();
		List<BoardVO> boardList = null;
		
		try {
			boardList = boardDao.getBoardList(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}




	@Override
	public int insertBoard(BoardVO boardVo) {
		boardDao = new BoardDao();
		int cnt = 0;
		
		try {
			cnt = boardDao.insertBoard(boardVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}




	@Override
	public int updateBoard(BoardVO boardVo) {
		boardDao = new BoardDao();
		int cnt = 0;
		try {
			cnt = boardDao.updateBoard(boardVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}




	@Override
	public List<BoardVO> getAllBoard() {
		boardDao = new BoardDao();
		List<BoardVO> boardList = null;
		try {
			boardList = boardDao.getAllBoard();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}




	@Override
	public BoardVO getBoard(String boardid) {
		boardDao = new BoardDao();
		
		BoardVO board = null;
		
		try {
			board = boardDao.getBoard(boardid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	
	
}
