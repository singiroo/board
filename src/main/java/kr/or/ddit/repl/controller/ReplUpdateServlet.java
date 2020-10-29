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
 * Servlet implementation class ReplUpdateServlet
 */
@WebServlet("/replUpdate")
public class ReplUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(ReplUpdateServlet.class);
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
		String replid = request.getParameter("replid");
		String replcont = request.getParameter("replUpdCont");
		ReplVO replVo = new ReplVO(replid, null, replcont, null, null, null, null);
		
		String postid = replService.updateRepl(replVo);
		
		if(postid != null) {
			response.sendRedirect(request.getContextPath()+"/post?postid="+postid);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/post?postid="+postid);			
		}
	}

}
