package kr.or.ddit.repl.dao;

import java.sql.SQLException;

import kr.or.ddit.repl.model.ReplVO;

public interface ReplDaoI {
	
	/**
	 * 댓글의 정보를 입력받아 댓글을 등록하는 메서드
	 * @param repl		댓글의 정보를 담고있는 VO객체
	 * @return			추가된 댓글의 갯수
	 * @throws SQLException
	 */
	public int insertRepl(ReplVO repl) throws SQLException;

}
