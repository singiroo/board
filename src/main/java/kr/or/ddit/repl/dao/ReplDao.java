package kr.or.ddit.repl.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.repl.model.ReplVO;

@Repository("replDao")
public class ReplDao implements ReplDaoI {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	
	
	@Override
	public int insertRepl(ReplVO repl){
		return sqlSession.insert("repl.insertRepl", repl);
	}



	@Override
	public String updateRepl(ReplVO repl){
		String postid = null;
		sqlSession.update("repl.updateRepl", repl);
		postid = repl.getPostid();
		return postid;
	}



	@Override
	public String deleteRepl(ReplVO repl){
		String postid = null;
		sqlSession.update("repl.deleteRepl", repl);
		postid = repl.getPostid();
		return postid;
	}
	
	
	
	
	

}
