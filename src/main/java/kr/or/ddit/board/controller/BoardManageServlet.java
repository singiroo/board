package kr.or.ddit.board.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.member.model.MemberVO;


@Controller
public class BoardManageServlet{
	private static final Logger logger = LoggerFactory.getLogger(BoardManageServlet.class);

	@Resource(name = "boardService")
	private BoardServiceI boardService;
	
       

	/**
	 * 게시판 관리 페이지로 이동
	 */
	@RequestMapping("/boardManage")
	public String boardManageView(HttpSession session, Model model) {
		MemberVO memberVo = (MemberVO) session.getAttribute("S_MEMBER");
		
		List<BoardVO> boardList = boardService.getBoardList(memberVo.getUserId());
		List<BoardVO> allBoardList = boardService.getAllBoard();
		
		session.setAttribute("S_BOARDLIST", allBoardList);
		
		model.addAttribute("boardList", boardList);
		
		return "tiles/board/boardManage";
	}
	
	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	}*/

}
