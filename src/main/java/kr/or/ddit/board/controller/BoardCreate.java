package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.member.model.MemberVO;

/**
 * Servlet implementation class BoardCreate
 */
@WebServlet("/boardCreate")
public class BoardCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardCreate.class);
    private BoardServiceI boardService;   
   

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		boardService = new BoardService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String boardnm = request.getParameter("boardnm");
		String userid = ((MemberVO)request.getSession().getAttribute("S_MEMBER")).getUserId();
		String boardstatus = "T";
		
		BoardVO board = new BoardVO();
		board.setBoardnm(boardnm);
		board.setUserid(userid);
		board.setBoardstatus(boardstatus);
		
		
		int cnt = boardService.insertBoard(board);
		logger.debug("result : {}",cnt);
	    if(cnt == 0) {
	    	doGet(request, response);
	    }else {
	    	response.sendRedirect(request.getContextPath()+"/boardManage");
	    }
		
		
		
		
		
	}

}
