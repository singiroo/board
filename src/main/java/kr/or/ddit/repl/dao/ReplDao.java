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
		System.out.println("dao-side-repl : "+repl.toString());
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

}
