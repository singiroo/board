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
	
	
	/**
	 * 댓글의 수정정보를 입력받아 댓글을 수정하는 메서드
	 * @param repl			댓글의 수정정보를 담고있는 VO객체
	 * @return				댓글의 부모글 아이디
	 * @throws SQLException
	 */
	public String updateRepl(ReplVO repl) throws SQLException;
	
	
	
	/**
	 * 댓글의 아이디를 입력받아 댓글을 삭제(활성화 구분 변경)하는 메서드
	 * @param repl			댓글의 아이디를 담고있는 VO 객체
	 * @return				댓글의 부모글 아이디
	 * @throws SQLException
	 */
	public String deleteRepl(ReplVO repl) throws SQLException;

}
