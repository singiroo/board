package kr.or.ddit.repl.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.repl.dao.ReplDaoI;
import kr.or.ddit.repl.model.ReplVO;

@Service("replService")
public class ReplService implements ReplServiceI {
	
	@Resource(name = "replDao")
	private ReplDaoI replDao;
	
	@Override
	public int insertRepl(ReplVO repl) {
		return replDao.insertRepl(repl);
	}

	@Override
	public String updateRepl(ReplVO repl) {
		return replDao.updateRepl(repl);
	}

	@Override
	public String deleteRepl(ReplVO repl) {
		return replDao.deleteRepl(repl);
	}

}
