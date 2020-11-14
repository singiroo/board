package kr.or.ddit.post.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;

/**
 * Servlet implementation class PostDeleteServlet
 */
@WebServlet("/deletePost")
public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostDeleteServlet.class);
	private PostServiceI postService;
       

	
	public void init(ServletConfig config) throws ServletException {
		postService = new PostService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postid = request.getParameter("postid");
		String boardid = request.getParameter("boardid");
		int cnt = postService.deletePost(postid);
		if(cnt == 1) {
			response.sendRedirect(request.getContextPath()+"/postList?boardid="+boardid);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/post?postid="+postid);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
