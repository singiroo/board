package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVO;

public interface BoardDaoI {
	
	
	public List<BoardVO> getBoardList(String userId);
	
	public int insertBoard(BoardVO boardVo);
	
	public int updateBoard(BoardVO boardVo);
	
	public List<BoardVO> getAllBoard();
	
	public BoardVO getBoard(String boardid);
	
	
}
