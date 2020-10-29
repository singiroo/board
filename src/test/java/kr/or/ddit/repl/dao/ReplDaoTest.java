package kr.or.ddit.repl.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import kr.or.ddit.repl.model.ReplVO;
import kr.or.ddit.repl.service.ReplService;
import kr.or.ddit.repl.service.ReplServiceI;

public class ReplDaoTest {

	private ReplDaoI replDao;

	@Test
	public void insertReplTest() {
		/***Given***/
		replDao = new ReplDao();
		ReplVO replVo = new ReplVO(null, "post7", "테스트댓글", null, "테스트2", "T", "brown");
		int cnt = 0;
		/***When***/
		try {
			cnt = replDao.insertRepl(replVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/***Then***/
		assertEquals(1, cnt);

	}
	
	
	@Test
	public void updateReplTest() {
		/***Given***/
		replDao = new ReplDao();
		ReplVO replVo = new ReplVO("repl6","post21" , "아 졸립구나..", null, null, "T", "brown");
		String postid = "post21";
		/***When***/
		String returnid = null;
		try {
			returnid = replDao.updateRepl(replVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/***Then***/
		assertEquals(postid, returnid);
	}
	
	
	@Test
	public void deleteReplTest() {
		/***Given***/
		replDao = new ReplDao();
		ReplVO replVo = new  ReplVO("repl6", null, null, null, null, "F", null);
		String postid = "post21";
		/***When***/
		String returnid = null;
		try {
			returnid = replDao.deleteRepl(replVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/***Then***/
		assertEquals(postid, returnid);

	}

}
