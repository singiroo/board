package kr.or.ddit.login.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;


@Controller
public class LoginServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	
	@Resource(name = "memberService")
	private MemberServiceI memberService;
	
	@Resource(name = "boardService")
	private BoardServiceI boardService;
	
	
	@RequestMapping("/login")
	public String loginView() {
		return "/login.jsp";
	}
	
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * request.getRequestDispatcher("/login.jsp").forward(request, response); }
	 */
	
	@RequestMapping("/Main")
	public String login(String userId, String pass, HttpSession session) {
		MemberVO memberVo = memberService.getMember(userId);
		List<BoardVO> boardList = boardService.getAllBoard();
		
		
		if(memberVo != null && memberVo.getPass().equals(pass)) {
			session.setAttribute("S_MEMBER", memberVo);
			session.setAttribute("S_BOARDLIST", boardList);
			return "/main.jsp";
		}
		
		return "redirect:/login";
	}
	
	
	
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * String userId = request.getParameter("userId"); String pass =
	 * request.getParameter("pass");
	 * 
	 * MemberVO memberVo = memberService.getMember(userId); List<BoardVO> boardList
	 * = boardService.getAllBoard();
	 * 
	 * 
	 * if(memberVo == null ) { doGet(request, response); } else
	 * if(pass.equals(memberVo.getPass())) { HttpSession session =
	 * request.getSession(); session.setAttribute("S_MEMBER", memberVo);
	 * session.setAttribute("S_BOARDLIST", boardList);
	 * request.getRequestDispatcher("/main.jsp").forward(request, response); }else {
	 * doGet(request, response); }
	 * 
	 * }
	 */

}
