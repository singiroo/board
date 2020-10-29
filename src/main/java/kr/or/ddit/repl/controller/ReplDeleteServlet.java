package kr.or.ddit.repl.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.repl.model.ReplVO;
import kr.or.ddit.repl.service.ReplService;
import kr.or.ddit.repl.service.ReplServiceI;

/**
 * Servlet implementation class ReplDeleteServlet
 */
@WebServlet("/replDelete")
public class ReplDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplServiceI replService;
	private static final Logger logger = LoggerFactory.getLogger(ReplDeleteServlet.class);
       

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		replService = new ReplService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String replid = request.getParameter("replid");
		ReplVO repl = new ReplVO(replid, null, null, null, null, null, null);
		String postid = replService.deleteRepl(repl);
		
		if(postid != null) {
			response.sendRedirect(request.getContextPath()+"/post?postid="+postid);
		}else {
			response.sendRedirect(request.getContextPath()+"/post?postid="+postid);			
		}
		
		
	
	}

}
