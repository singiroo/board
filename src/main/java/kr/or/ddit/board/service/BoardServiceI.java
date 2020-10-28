package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVO;

public interface BoardServiceI {
	
	
	/**
	 * 사용자의 아이디를 입력받아 사용자의 게시판 리스트를 가져오는 메서드
	 * @param userId			사용자의 아이디
	 * @return					사용자의 게시판 리스트
	 */
	public List<BoardVO> getBoardList(String userId);
	
	/**
	 * 사용자에게 게시판의 정보를 입력받아 게시판을 추가하는 메서드
	 * @param boardVo		추가할 게시판의 정보를 담고있는 vo객체
	 * @return				추가한 게시판의 갯수
	 */
	public int insertBoard(BoardVO boardVo);
	
	
	/**
	 * 게시판의 아이디와 게시판의 상태 정보를 입력받아 게시판의 상태정보를 수정하는 메서드
	 * @param boardVo		게시판의 아이디와 수정할 게시판의 상태정보를 담고있는 VO객체
	 * @return				상태정보가 수정된 게시판의 갯수
	 */
	public int updateBoard(BoardVO boardVo);
	
	/**
	 * 등록된 모든 활성화 게시판의 목록을 가져오는 메서드
	 * @return		활성화된 모든 게시판의 목록
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * 게시판의 아이디를 입력받아 해당 게시판을 가져오는 메서드
	 * @param boardid		게시판의 아이디
	 * @return				게시판의 정보를 담고있는 VO객체
	 */
	public BoardVO getBoard(String boardid);
	
	
	

}
