package kr.or.ddit.repl.service;

import java.sql.SQLException;

import kr.or.ddit.repl.dao.ReplDao;
import kr.or.ddit.repl.dao.ReplDaoI;
import kr.or.ddit.repl.model.ReplVO;

public class ReplService implements ReplServiceI {
	
	private ReplDaoI replDao;
	
	@Override
	public int insertRepl(ReplVO repl) {
		replDao = new ReplDao();
		int cnt = 0;
		
		try {
			cnt = replDao.insertRepl(repl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

}
