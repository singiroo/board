package kr.or.ddit.repl.service;

import kr.or.ddit.repl.model.ReplVO;

public interface ReplServiceI {
	
	/**
	 * 댓글 정보를 입력받아 댓글을 등록하는 메서드
	 * @param repl			댓글의 정보를 담고있는 VO 객체
	 * @return				추가된 댓글의 갯수
	 */
	public int insertRepl(ReplVO repl);

}
