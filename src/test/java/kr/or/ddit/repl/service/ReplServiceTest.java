package kr.or.ddit.repl.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.repl.model.ReplVO;

public class ReplServiceTest extends ModelTestConfig {
	
	@Resource(name = "replService")
	private ReplServiceI replService;
	
	@Test
	public void insertReplTest() {
		/***Given***/
		ReplVO repl = new ReplVO(null, "post86", "testrepl", null, "testrepl", "T", "brown");
		/***When***/
		int cnt = replService.insertRepl(repl);
		/***Then***/
		assertEquals(1, cnt);

	}
	
	@Test
	public void updateReplTest() {
		/***Given***/
		ReplVO repl = new ReplVO("repl34", "post7", null, null, null, "F", "brown");
		/***When***/
		String postid = replService.deleteRepl(repl);
		/***Then***/
		assertEquals("post7", postid);
	}
	
	@Test
	public void deleteReplTest() {
		/***Given***/
		ReplVO repl = new ReplVO("repl34", "post7", "testmodified", null, "modified", "T", "brown");
		/***When***/
		String postid = replService.updateRepl(repl);
		/***Then***/
		assertEquals("post7", postid);
	}

}
