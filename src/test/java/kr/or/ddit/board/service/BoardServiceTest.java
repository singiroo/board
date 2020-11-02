package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import kr.or.ddit.board.model.BoardVO;

public class BoardServiceTest {
	
	private BoardServiceI boardService;
	
	
	@Test
	public void getBoardListTest() {
		/***Given***/
		boardService = new BoardService();
		String userid = "brown";
		/***When***/
		List<BoardVO> boardList = boardService.getBoardList(userid);
		
		/***Then***/
		assertEquals(5, boardList.size());
		
	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		boardService = new BoardService();
		BoardVO boardVo = new BoardVO(null, "테스트게시판", "T", "brown");
		int cnt = 0;
		/***When***/

		cnt = boardService.insertBoard(boardVo);
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		boardService = new BoardService();
		BoardVO boardVo = new BoardVO("board8", "테스트게시판2", "T", "brown");		
		/***When***/
		int cnt = boardService.updateBoard(boardVo);
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void getAllBoardTest() {
		/***Given***/
		boardService = new BoardService();
		List<BoardVO> boardList = new ArrayList<>();
		/***When***/
		boardList = boardService.getAllBoard();
		/***Then***/
		assertEquals(8, boardList.size());
	}
	
	@Test
	public void getBoardTest() {
		/***Given***/
		boardService = new BoardService();
		BoardVO boardVo = new BoardVO();
		String boardid = "board8";
		String boardnm = "테스트게시판";
		/***When***/
		boardVo = boardService.getBoard(boardid);
		/***Then***/
		assertEquals(boardnm, boardVo.getBoardnm());

	}
	

}
