package kr.or.ddit.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.model.BoardVO;

@Service("boardService")
public class BoardService implements BoardServiceI{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Resource(name = "boardDao")
	private BoardDaoI boardDao;
	
	
	
	
	@Override
	public List<BoardVO> getBoardList(String userId) {
		return boardDao.getBoardList(userId);
	}




	@Override
	public int insertBoard(BoardVO boardVo) {
		return boardDao.insertBoard(boardVo);
	}




	@Override
	public int updateBoard(BoardVO boardVo) {
		return boardDao.updateBoard(boardVo);
	}




	@Override
	public List<BoardVO> getAllBoard() {
		return boardDao.getAllBoard();
	}




	@Override
	public BoardVO getBoard(String boardid) {
		return boardDao.getBoard(boardid);
	}

	
	
}
