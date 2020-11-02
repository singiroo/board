package kr.or.ddit.login.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceI memberService;
	private BoardServiceI boardService;
	
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
		boardService = new BoardService();
	}
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		MemberVO memberVo = memberService.getMember(userId);
		List<BoardVO> boardList = boardService.getAllBoard();
		
		
		if(memberVo == null ) {
			doGet(request, response);
		}
		else if(pass.equals(memberVo.getPass())) {
			HttpSession session = request.getSession();
			session.setAttribute("S_MEMBER", memberVo);
			session.setAttribute("S_BOARDLIST", boardList);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else {
			doGet(request, response);
		}
		
	}

}
