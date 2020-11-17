package kr.or.ddit.repl.dao;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.repl.model.ReplVO;

public class ReplDaoTest extends ModelTestConfig {
	
	@Resource(name = "replDao")
	private ReplDaoI replDao;
	
	
	@Test
	public void insertReplTest() {
		/***Given***/
		ReplVO repl = new ReplVO(null, "post86", "testrepl", null, "testrepl", "T", "brown");
		/***When***/
		int cnt = replDao.insertRepl(repl);
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void deleteReplTest() {
		/***Given***/
		ReplVO repl = new ReplVO("repl34", "post7", null, null, null, "F", "brown");
		/***When***/
		String postid = replDao.deleteRepl(repl);
		/***Then***/
		assertEquals("post7", postid);
	}

	@Test
	public void updateReplTest() {
		/***Given***/
		ReplVO repl = new ReplVO("repl34", "post7", "testmodified", null, "modified", "T", "brown");
		
		/***When***/
		String postid = replDao.updateRepl(repl);
		/***Then***/
		assertEquals("post7", postid);

	}
	

}
