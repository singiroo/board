package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.model.BoardVO;

public interface BoardDaoI {
	
	
	public List<BoardVO> getBoardList(String userId) throws SQLException;
	
	public int insertBoard(BoardVO boardVo) throws SQLException;
	
	public int updateBoard(BoardVO boardVo) throws SQLException;
	
	public List<BoardVO> getAllBoard() throws SQLException;
	
	public BoardVO getBoard(String boardid) throws SQLException;
	
	
}
