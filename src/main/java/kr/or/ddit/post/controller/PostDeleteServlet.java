package kr.or.ddit.post.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.post.service.PostServiceI;


@Controller 
public class PostDeleteServlet{
	private static final Logger logger = LoggerFactory.getLogger(PostDeleteServlet.class);
	
	@Resource(name = "postService")
	private PostServiceI postService;
       
	
	@RequestMapping("/deletePost")
	public String deletePost(String boardid, String postid) {
		String redirectUrl = "";
		int cnt = postService.deletePost(postid);
		
		if(cnt == 1) {
			redirectUrl = "redirect:/postList?boardid="+boardid;
		}else {
			redirectUrl = "redirect:/post?postid="+postid;
		}
		
		return redirectUrl;
	}
	
	
	
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String postid =
	 * request.getParameter("postid"); String boardid =
	 * request.getParameter("boardid"); int cnt = postService.deletePost(postid);
	 * if(cnt == 1) {
	 * response.sendRedirect(request.getContextPath()+"/postList?boardid="+boardid);
	 * } else {
	 * response.sendRedirect(request.getContextPath()+"/post?postid="+postid); }
	 * 
	 * }
	 * 
	 * 
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub doGet(request, response); }
	 */

}
