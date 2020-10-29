package kr.or.ddit.post.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.post.model.PostVO;

public class PostDaoTest {
	private PostDaoI postDao;
	private SqlSession sqlSession;
	
	@Test
	public void getAllPostCntTest() {
		/***Given***/
		postDao = new PostDao();
		sqlSession = MybatisUtil.getSqlSession();
		String boardid = "board2";
		int cnt = 0;
		/***When***/
		try {
			cnt = postDao.getAllPostCnt(sqlSession, boardid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sqlSession.close();
		/***Then***/
		assertEquals(15, cnt);
	
	}
	
	@Test
	public void insertPostTest() {
		/***Given***/
		postDao = new PostDao();
		sqlSession = MybatisUtil.getSqlSession();
		String parentid = "";
		PostVO postVo = new PostVO("board2", null, parentid, "메서드 테스트 게시글", "<p>메서드 테스트 게시글입니다.</p>", null, "T", "brown");
		String postid = null;
		/***When***/
		try {
			postid = postDao.insertPost(sqlSession, postVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sqlSession.close();
		/***Then***/
		assertNotNull(postid);
	}
	
	@Test
	public void getPostTest() {
		/***Given***/
		postDao = new PostDao();
		sqlSession = MybatisUtil.getSqlSession();
		String postid = "post12";
		String title ="테스트";
		PostVO postVo = new PostVO();
		/***When***/
		try {
			postVo = postDao.getPost(sqlSession, postid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sqlSession.close();
		/***Then***/
		assertEquals(title, postVo.getTitle());
	}
	
	@Test
	public void updatePostTest() {
		/***Given***/
		postDao = new PostDao();
		sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		String postid = "post12";
		String title ="메서드-테스트";
		PostVO postVo = new PostVO("board2", postid, "post9", title, "<p>테스트케이스</p>", null, "T", "brown");
		/***When***/
		try {
			cnt = postDao.updatePost(sqlSession, postVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sqlSession.close();
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void deletePostTest() {
		/***Given***/
		postDao = new PostDao();
		int cnt = 0;
		String postid = "post12";
		/***When***/
		try {
			cnt = postDao.deletePost(postid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		/***Then***/
		assertEquals(1, cnt);
	}
	

}
