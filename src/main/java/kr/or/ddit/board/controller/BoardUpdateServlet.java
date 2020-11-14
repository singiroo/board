package kr.or.ddit.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardServiceI;


@Controller
public class BoardUpdateServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(BoardUpdateServlet.class);
    
    @Resource(name = "boardService")
    private BoardServiceI boardService;
  
	
	@RequestMapping("/updateBoard")
	public String updateBoard(BoardVO boardVo) {
		boardService.updateBoard(boardVo);
		return "redirect:/boardManage";
	}

	
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * request.setCharacterEncoding("utf-8"); String boardid =
	 * request.getParameter("boardid"); String boardstatus =
	 * request.getParameter("boardstatus"); BoardVO boardVo = new BoardVO(boardid,
	 * null, boardstatus, null); int cnt = boardService.updateBoard(boardVo);
	 * 
	 * if(cnt == 1) {
	 * response.sendRedirect(request.getContextPath()+"/boardManage"); } }
	 */

}
