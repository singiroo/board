package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import kr.or.ddit.board.model.BoardVO;

public class BoardDaoTest {
	private BoardDaoI boardDao;

	@Test
	public void getBoardListTest() {
		/***Given***/
		boardDao = new BoardDao();
		String userid = "brown";
		List<BoardVO> boardList = new ArrayList<>();
		/***When***/
		
		try {
			boardList = boardDao.getBoardList(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/***Then***/
		assertEquals(5, boardList.size());
		
	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		boardDao = new BoardDao();
		BoardVO boardVo = new BoardVO(null, "공지게시판", "T", "brown");
		int cnt = 0;
		/***When***/
		try {
			cnt = boardDao.insertBoard(boardVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		boardDao = new BoardDao();
		BoardVO boardVo = new BoardVO("board7", "공지게시판-수정", "T", "brown");
		int cnt = 0;
		/***When***/
		try {
			cnt = boardDao.updateBoard(boardVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void getAllBoardTest() {
		/***Given***/
		boardDao = new BoardDao();
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		/***When***/
		try {
			boardList = boardDao.getAllBoard();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/***Then***/
		assertEquals(8, boardList.size());
	}
	
	@Test
	public void getBoardTest() {
		/***Given***/
		boardDao = new BoardDao();
		String boardid = "board7";
		String boardnm = "공지게시판";
		BoardVO board = new BoardVO();
		/***When***/
		try {
			board = boardDao.getBoard(boardid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		/***Then***/
		assertEquals(boardnm, board.getBoardnm());
	}
	
	
	
	
	
	

}
