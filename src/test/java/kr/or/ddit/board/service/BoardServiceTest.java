package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.board.model.BoardVO;

public class BoardServiceTest extends ModelTestConfig {

	@Resource(name = "boardService")
	private BoardServiceI boardService;
	
	@Test
	public void getBoardListTest() {
		/***Given***/
		String userid = "brown";
		/***When***/
		List<BoardVO> boardList = boardService.getBoardList(userid);
		/***Then***/
		assertTrue(boardList.size() > 10);

	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		BoardVO boardVo = new BoardVO(null, "testcode", "T0", "brown");
		/***When***/
		int cnt = boardService.insertBoard(boardVo);
		/***Then***/
		assertEquals(1, cnt);
		

	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		BoardVO boardVo = new BoardVO("board3", "A", "T", "brown");
		/***When***/
		int cnt = boardService.updateBoard(boardVo);
		/***Then***/
		assertEquals(1, cnt);
		
	}
	
	@Test
	public void getAllBoardTest() {
		/***Given***/
		
		/***When***/
		List<BoardVO> boardList = boardService.getAllBoard();
		/***Then***/
		assertTrue(boardList.size() > 10);
	}
	
	@Test
	public void getBoardTest() {
		/***Given***/
		String boardid = "board3";
		/***When***/
		BoardVO boardVo = boardService.getBoard(boardid);
		/***Then***/
		assertEquals("Q", boardVo.getBoardnm());
	}

}
