package kr.or.ddit.post.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.post.model.PostVO;

public interface PostDaoI {
	
	
	/**
	 * 게시판의 아이디, 페이지 정보를 입력받아 페이지에 출력할 게시글 목록을 가져오는 메서드
	 * @param sqlSession SqlSession 객체
	 * @param map		게시판의 아이디와 페이지 정보를 담고있는 HashMap객체
	 * @return			출력할 페이지의 게시글 목록
	 */
	public List<PostVO> getPostList(SqlSession sqlSession, Map<String, Object> map) throws SQLException;
	
	/**
	 * 게시판 아이디 정보를 입력받아 해당 게시판의 모든 게시글의 갯수를 가져오는 메서드
	 * @param sqlSession	SqlSession 객체
	 * @param boardid		게시판의 아이디
	 * @return				해당 게시판의 모든 글의 갯수
	 */
	public int getAllPostCnt(SqlSession sqlSession, String boardid) throws SQLException;
	

}
