package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.board.model.BoardVO;

public class BoardDaoTest extends ModelTestConfig {
	
	
	@Resource(name = "boardDao")
	private BoardDaoI boardDao;
	
	
	@Test
	public void getBoardListTest() {
		/***Given***/
		String userid = "brown";
		/***When***/
		
		List<BoardVO> boardList = boardDao.getBoardList(userid);
		
		/***Then***/
		assertTrue(boardList.size() > 20);	
	}
	
	@Test
	public void insertBoardTest() {
  		/***Given***/
		BoardVO board = new BoardVO(null, "testcode", "T0", "brown");
		/***When***/
		int cnt = boardDao.insertBoard(board);

		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		BoardVO board = new BoardVO("board3", "A", "T", "brown");
		/***When***/
		int cnt = boardDao.updateBoard(board);
		/***Then***/
		assertEquals(1, cnt);
		
	}
	
	@Test
	public void getAllBoardTest() {
		/***Given***/
		
		/***When***/
		List<BoardVO> boardList = boardDao.getAllBoard();
		/***Then***/
		assertTrue(boardList.size() > 0);

	}
	
	@Test
	public void getBoardTest() {
		/***Given***/
		String boardid = "board3";
		/***When***/
		BoardVO boardVo = boardDao.getBoard(boardid);
		/***Then***/
		assertEquals("Q", boardVo.getBoardnm());

	}
}
