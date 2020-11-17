package kr.or.ddit.post.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.file.model.AttachFileVO;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.repl.model.ReplVO;

public class PostDaoTest extends ModelTestConfig {
	
	@Resource(name = "postDao")
	private PostDaoI postDao;
	
	@Test
	public void getPostListTest() {
		/***Given***/
		Map<String,	Object> map = new HashedMap<String, Object>();
		PageVO page = new PageVO(1, 8);
		String boardid = "board2";
		map.put("page", page);
		map.put("boardid", boardid);
		
		/***When***/
		List<PostVO> postList = postDao.getPostList(map);

		/***Then***/
		assertEquals(page.getPageSize(), postList.size());
	}
	
	@Test
	public void getAllPostCntTest() {
		/***Given***/
		String boardid = "board2";
		/***When***/
		int cnt = postDao.getAllPostCnt(boardid);
		/***Then***/
		assertTrue(cnt > 20);

	}
	
	@Test
	public void insertPostTest() {
		/***Given***/
		PostVO post = new PostVO("board2", null, null, "testcode", "testcode", null, "T", "brown");
		/***When***/
		String postid = postDao.insertPost(post);
		/***Then***/
		assertNotNull(postid);
	}
	
	@Test
	public void insertFileTest() {
		/***Given***/
		List<AttachFileVO> fileList = new ArrayList<AttachFileVO>();
		AttachFileVO file = new AttachFileVO(null, "testcode", "testcode.txt", "post86");
		fileList.add(file);
		file = new AttachFileVO(null, "testcode2", "testcode2.txt", "post86");
		fileList.add(file);
		/***When***/
		int cnt = postDao.insertFile(fileList);
		/***Then***/
		assertEquals(2, cnt);

	}
	
	@Test
	public void getPostTest() {
		/***Given***/
		String postid = "post86";
		/***When***/
		PostVO post = postDao.getPost(postid);
		/***Then***/
		assertNotNull(post);
		
	}
	
	@Test 
	public void getFileListTest() {
		/***Given***/
		String postid = "post86";
		/***When***/
		List<AttachFileVO> fileList = postDao.getFileList(postid);
		/***Then***/
		assertEquals(3, fileList.size());
	}
	
	@Test
	public void updatePostTest() {
		/***Given***/
		PostVO post = new PostVO(null, "post86", null, "modified test", "modified", null, "T", "brown");
		/***When***/
		int cnt = postDao.updatePost(post);

		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void deletePostTest() {
		/***Given***/
		String postid = "post86";
		/***When***/
		int cnt = postDao.deletePost(postid);
		/***Then***/
		assertEquals(1, cnt);
		

	}
	
	@Test
	public void deletefileTest() {
		/***Given***/
		List<String> delList = new ArrayList<String>();
		delList.add("file85");
		delList.add("file86");
		/***When***/
		int cnt = postDao.deleteFile(delList);
		/***Then***/
		assertEquals(2, cnt);
	}
	
	@Test
	public void getReplListTest() {
		/***Given***/
		String postid = "post7";
		/***When***/
		List<ReplVO> replList = postDao.getReplList(postid);

		/***Then***/
		assertNotNull(replList);
	}
}
