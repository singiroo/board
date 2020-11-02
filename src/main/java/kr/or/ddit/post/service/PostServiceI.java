package kr.or.ddit.post.service;

import java.util.Map;

public interface PostServiceI {
	
	/**
	 * 게시판의 아이디, 출력할 페이지와 페이지당 출력 수를 입력받아 게시글 목록 페이지를 출력할 정보를 가져오는 메서드 
	 * @param map		게시판의 아이디, 페이지 정보가 담긴 HashMap 객체
	 * @return			출력할 게시글 목록과 페이지 정보가 담긴 HashMap 객체
	 */
	public Map<String, Object> getPostListPage(Map<String, Object> map);
	
	
	/**
	 * 사용자가 작성한 게시글과 게시글에 첨부한 파일을 등록하는 메서드
	 * @param map			작성한 게시글의 정보와 첨부파일의 정보를 담고있는 HashMap객체
	 * @return				등록된 글의 갯수
	 */
	public int insertPost(Map<String, Object> map);
	
	
	/**
	 * 게시글의 아이디를 입력받아 해당 게시글과 파일을 가져오는 메서드
	 * @param postid		게시글의 아이디
	 * @return				게시글의 정보와 첨부파일의 리스트를 담은 HashMap객체
	 */
	public Map<String, Object> getPost(String postid);
	
	
	/**
	 * 게시글 정보와 파일 정보를 입력받아 게시글을 수정하는 메서드
	 * @param map			게시글의 정보와 파일 리스트, 지울 파일 목록을 담은 HashMap 객체
	 * @return				수정된 게시글의 갯수
	 */
	public int updatePost(Map<String, Object> map);
	
	
	/**
	 * 게시글 아이디를 입력받아 해당 게시글을 삭제(상태구분 변경)하는 메서드
	 * @param postid		게시글의 아이디
	 * @return				삭제된 게시글의 갯수
	 */
	public int deletePost(String postid);
	

}
