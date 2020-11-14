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
 * Servlet implementation class ReplCreateServlet
 */
@WebServlet("/replCreate")
public class ReplCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ReplCreateServlet.class);
    private ReplServiceI replService;   
   

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		replService = new ReplService();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String postid = request.getParameter("postid");
		String userid = request.getParameter("repluserid");
		String title = request.getParameter("repltitle");
		String cont = request.getParameter("replcont");
		
		
		ReplVO repl = new ReplVO(null, postid, cont, null, title, null, userid);
		
		logger.debug("repl : {}", repl.toString());
		int cnt = replService.insertRepl(repl);
		
		if(cnt == 1) {
			response.sendRedirect(request.getContextPath()+"/post?postid="+postid);
		}
		else {
			//에러페이지 생성
			response.sendRedirect(request.getContextPath()+"/post?postid="+postid);			
		}
		
	}

}
