package kr.or.ddit.post.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.post.service.PostServiceI;

@Controller
public class PostServlet {
	private static final Logger logger = LoggerFactory.getLogger(PostServlet.class);

	@Resource(name = "postService")
	private PostServiceI postService;

	@RequestMapping("/post")
	public String getPost(String postid, Model model) {
		Map<String, Object> map = postService.getPost(postid);
		model.addAttribute("map", map);
		return "/post/postView.jsp";
	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String postid =
	 * request.getParameter("postid");
	 * 
	 * Map<String, Object> map = postService.getPost(postid);
	 * 
	 * request.setAttribute("map", map);
	 * 
	 * request.getRequestDispatcher("/post/postView.jsp").forward(request,
	 * response);
	 * 
	 * }
	 * 
	 *
	 *
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub doGet(request, response); }
	 */

}
