package kr.or.ddit.post.service;

import java.util.Map;

public interface PostServiceI {
	
	/**
	 * 게시판의 아이디, 출력할 페이지와 페이지당 출력 수를 입력받아 게시글 목록 페이지를 출력할 정보를 가져오는 메서드 
	 * @param map		게시판의 아이디, 페이지 정보가 담긴 HashMap 객체
	 * @return			출력할 게시글 목록과 페이지 정보가 담긴 HashMap 객체
	 */
	public Map<String, Object> getPostListPage(Map<String, Object> map);

}
