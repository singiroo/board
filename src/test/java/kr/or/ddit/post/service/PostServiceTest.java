package kr.or.ddit.post.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.file.model.AttachFileVO;
import kr.or.ddit.post.model.PostVO;

public class PostServiceTest extends ModelTestConfig {
	
	@Resource(name = "postService")
	private PostServiceI postService;
	
	
	@Test
	public void getPostListPageTest() {
		/***Given***/
		Map<String,	Object> map = new HashedMap<String, Object>();
		PageVO page = new PageVO(1, 8);
		String boardid = "board2";
		map.put("page", page);
		map.put("boardid", boardid);
		/***When***/
		Map<String, Object> resultMap = postService.getPostListPage(map);
		/***Then***/
		assertNotNull(resultMap);

	}
	
	@Test
	public void insertPostTest() {
		/***Given***/
		Map<String, Object> map = new HashMap<String, Object>();
		PostVO post = new PostVO("board2", null, null, "testcode", "testcode", null, "T", "brown");
		List<AttachFileVO> fileList = new ArrayList<AttachFileVO>();
		AttachFileVO file = new AttachFileVO(null, "testcode", "testcode.txt", "post86");
		fileList.add(file);
		file = new AttachFileVO(null, "testcode2", "testcode2.txt", "post86");
		fileList.add(file);
		map.put("postVo", post);
		map.put("fileList", fileList);
		
		/***When***/
		int cnt = postService.insertPost(map);
		
		/***Then***/
		assertTrue(cnt > 0);
	}
	
	@Test
	public void getPostTest() {
		/***Given***/
		String postid = "post86";
		/***When***/
		Map<String, Object> map = postService.getPost(postid);
		/***Then***/
		assertNotNull(map);
	}
	
	@Test
	public void updatePost() {
		/***Given***/
		Map<String, Object> map = new HashMap<String, Object>();
		PostVO post = new PostVO(null, "post86", null, "modified test", "modified", null, "T", "brown");
		List<AttachFileVO> fileList = new ArrayList<AttachFileVO>();
		AttachFileVO file = new AttachFileVO(null, "testcode", "testcode.txt", "post86");
		fileList.add(file);
		file = new AttachFileVO(null, "testcode2", "testcode2.txt", "post86");
		fileList.add(file);
		List<String> delList = new ArrayList<String>();
		delList.add("file85");
		delList.add("file86");
		map.put("postVo", post);
		map.put("fileList", fileList);
		map.put("delList", delList);
		
		/***When***/
		int cnt = postService.updatePost(map);
		/***Then***/
		assertTrue(cnt > 0);

	}
	
	@Test
	public void deletePostTest() {
		/***Given***/
		String postid = "post86";
		/***When***/
		int cnt = postService.deletePost(postid);
		/***Then***/
		assertEquals(1, cnt);
	}

}
