package kr.or.ddit.board.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardServiceI;


@Controller
public class BoardCreate{
	private static final Logger logger = LoggerFactory.getLogger(BoardCreate.class);
    @Resource(name = "boardService")
	private BoardServiceI boardService;   
   
    
    @RequestMapping("/boardCreate")
    public String boardCreate(BoardVO boardVo, Model model) {
    	boardService.insertBoard(boardVo);
    	return "redirect:/boardManage";
    }
	
  
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * request.setCharacterEncoding("utf-8"); String boardnm =
	 * request.getParameter("boardnm"); String userid =
	 * ((MemberVO)request.getSession().getAttribute("S_MEMBER")).getUserId(); String
	 * boardstatus = "T";
	 * 
	 * BoardVO board = new BoardVO(); board.setBoardnm(boardnm);
	 * board.setUserid(userid); board.setBoardstatus(boardstatus);
	 * 
	 * 
	 * int cnt = boardService.insertBoard(board); logger.debug("result : {}",cnt);
	 * if(cnt == 0) { doGet(request, response); }else {
	 * response.sendRedirect(request.getContextPath()+"/boardManage"); }
	 * 
	 * }
	 */

}
