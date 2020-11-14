package kr.or.ddit.repl.service;

import kr.or.ddit.repl.model.ReplVO;

public interface ReplServiceI {
	
	/**
	 * 댓글 정보를 입력받아 댓글을 등록하는 메서드
	 * @param repl			댓글의 정보를 담고있는 VO 객체
	 * @return				추가된 댓글의 갯수
	 */
	public int insertRepl(ReplVO repl);
	
	
	/**
	 * 댓글 수정 정보를 입력받아 댓글을 수정하는 메서드
	 * @param repl			댓글 수정 정보를 담고 있는 VO 객체
	 * @return				댓글의 부모글 아이디
	 */
	public String updateRepl(ReplVO repl);
	
	
	/**
	 * 댓글의 아이디를 입력받아 댓글을 삭제(활성화 구분 변경)하는 메서드
	 * @param repl			댓글 아이디를 담고있는 VO객체
	 * @return				댓글의 부모글 아이디
	 */
	public String deleteRepl(ReplVO repl);

}
