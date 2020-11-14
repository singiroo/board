package kr.or.ddit.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.BoardVO;

@Repository("boardDao")
public class BoardDao implements BoardDaoI {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<BoardVO> getBoardList(String userId){		
		logger.debug("BoardDao.getBoardList - userid : {}", userId);
		return sqlSession.selectList("board.getBoardList", userId);
	}


	@Override
	public int insertBoard(BoardVO boardVo){
		return sqlSession.insert("board.insertBoard", boardVo);
	}




	@Override
	public int updateBoard(BoardVO boardVo){
		return sqlSession.update("board.updateBoard", boardVo);
	}




	@Override
	public List<BoardVO> getAllBoard(){
		return sqlSession.selectList("board.getAllBoard");
	}




	@Override
	public BoardVO getBoard(String boardid){
		return sqlSession.selectOne("board.getBoard", boardid);
	}

}
