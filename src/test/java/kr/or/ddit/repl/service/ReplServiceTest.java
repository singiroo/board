package kr.or.ddit.repl.service;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.repl.model.ReplVO;

public class ReplServiceTest {
	private ReplServiceI replService;

	@Test
	public void insertReplTest() {
		/***Given***/
		replService = new ReplService();
		ReplVO replVo = new ReplVO(null, "post7", "테스트댓글", null, "테스트", "T", "brown");
		int cnt = 0;
		/***When***/
		cnt = replService.insertRepl(replVo);
		/***Then***/
		assertEquals(1, cnt);

	}
	
	
	@Test
	public void updateReplTest() {
		/***Given***/
		replService = new ReplService();
		ReplVO replVo = new ReplVO("repl5","post17" , "아 테스트코드란..", null, null, "T", "brown");
		String postid = "post17";
		/***When***/
		String returnid = replService.updateRepl(replVo);
		/***Then***/
		assertEquals(postid, returnid);
	}
	
	
	@Test
	public void deleteReplTest() {
		/***Given***/
		replService = new ReplService();
		ReplVO replVo = new  ReplVO("repl5", null, null, null, null, "F", null);
		String postid = "post17";
		/***When***/
		String returnid = replService.deleteRepl(replVo);
		/***Then***/
		assertEquals(postid, returnid);

	}

}
