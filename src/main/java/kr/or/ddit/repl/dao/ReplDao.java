package kr.or.ddit.repl.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.repl.model.ReplVO;

public class ReplDao implements ReplDaoI {
	
	private SqlSession sqlSession;
	
	
	
	@Override
	public int insertRepl(ReplVO repl) throws SQLException {
		sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		cnt = sqlSession.insert("repl.insertRepl", repl);
		if(cnt == 1) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}



	@Override
	public String updateRepl(ReplVO repl) throws SQLException {
		sqlSession = MybatisUtil.getSqlSession();
		String postid = null;
		
		sqlSession.update("repl.updateRepl", repl);
		
		postid = repl.getPostid();
		
		
		if(postid != null) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return postid;
	}



	@Override
	public String deleteRepl(ReplVO repl) throws SQLException {
		sqlSession = MybatisUtil.getSqlSession();
		String postid = null;
		
		sqlSession.update("repl.deleteRepl", repl);
		
		postid = repl.getPostid();
		
		
		if(postid != null) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return postid;
	}
	
	
	
	
	

}
