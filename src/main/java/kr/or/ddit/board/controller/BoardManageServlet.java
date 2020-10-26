package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.member.model.MemberVO;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/boardManage")
public class BoardManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceI boardService;
	private static final Logger logger = LoggerFactory.getLogger(BoardManageServlet.class);
       

	
	public void init(ServletConfig config) throws ServletException {
		boardService = new BoardService();
	}

	/**
	 * 게시판 관리 페이지로 이동
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO memberVo = (MemberVO)session.getAttribute("S_MEMBER");
		logger.debug("memberVo : {}", memberVo.toString());
		
		String userId = memberVo.getUserId();
		
		List<BoardVO> boardList = boardService.getBoardList(userId);
		List<BoardVO> allList = boardService.getAllBoard();
		
		logger.debug("count : {} ",boardList.size());
		
		request.getSession().setAttribute("S_BOARDLIST", allList);
		
		
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("/board/boardManage.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
