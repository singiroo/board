package kr.or.ddit.post.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.file.model.AttachFileVO;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.repl.model.ReplVO;

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
	
	
	/**
	 * 게시글 정보를 입력받아 게시글을 등록하고 등록한 게시글의 아이디를 가져오는 메서드
	 * @param sqlSession	SqlSession객체
	 * @param postVo		게시글 정보를 담고있는 VO객체
	 * @return				등록한 게시글의 아이디
	 * @throws SQLException	
	 */
	public String insertPost(SqlSession sqlSession, PostVO postVo) throws SQLException;

	/**
	 * 게시글 작성 시 첨부한 파일의 정보를 담고있는 VO객체의 리스트를 입력받아 파일을 등록하는 메서드
	 * @param sqlSession	SqlSession객체
	 * @param fileList		파일 VO객체의 리스트
	 * @return				등록한 파일의 수
	 */
	public int insertFile(SqlSession sqlSession, List<AttachFileVO> fileList) throws SQLException;
	
	
	/**
	 * 게시글 아이디를 입력받아 게시글을 가져오는 메서드
	 * @param postid		게시글의 아이디
	 * @return				게시글의 정보를 담은 VO객체
	 * @throws SQLException
	 */
	public PostVO getPost(SqlSession sqlSession, String postid) throws SQLException;
	
	
	/**
	 * 게시글 아이디를 입력받아 게시글에 첨부된 파일의 목록을 가져오는 메서드
	 * @param postid		게시글의 아이디
	 * @return				게시글에 첨부된 파일들의 리스트
	 * @throws SQLException
	 */
	public List<AttachFileVO> getFileList(SqlSession sqlSession, String postid) throws SQLException;
	
	
	/**
	 * 게시글의 정보를 입력받아 게시글을 수정하는 메서드
	 * @param postVo		게시글의 정보를 담고 있는 VO객체
	 * @return				수정된 게시글의 갯수
	 * @throws SQLException
	 */
	public int updatePost(SqlSession sqlSession, PostVO postVo) throws SQLException;
	
	
	/**
	 * 게시글의 아이디를 입력받아 게시글을 삭제(상태 구분 변경)하는 메서드
	 * @param postid 		게시글의 아이디
	 * @return				삭제된 게시글의 갯수
	 * @throws SQLException
	 */
	public int deletePost(String postid) throws SQLException;
	
	/**
	 * 파일의 아이디 목록을 입력받아 파일을 삭제하는 메서드
	 * @param sqlSession	
	 * @param delList			파일의 아이디 목록
	 * @return					삭제된 파일의 갯수
	 * @throws SQLException
	 */
	public int deleteFile(SqlSession sqlSession, List<String> delList) throws SQLException;
	
	
	/**
	 * 게시글의 아이디를 입력받아 해당 게시글의 댓글 목록을 가져오는 메서드
	 * @param sqlSession
	 * @param postid			게시글의 아이디
	 * @return					게시글의 댓글 목록
	 * @throws SQLException
	 */
	public List<ReplVO> getReplList(SqlSession sqlSession, String postid) throws SQLException;
	
	
	

}

