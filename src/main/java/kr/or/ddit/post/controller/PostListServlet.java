package kr.or.ddit.post.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.post.service.PostServiceI;


@Controller
public class PostListServlet{
	private static final Logger logger = LoggerFactory.getLogger(PostListServlet.class);
	
	@Resource(name = "postService")
	private PostServiceI postService;
	
	@Resource(name = "boardService")
	private BoardServiceI boardService;
       
	
	@RequestMapping("/postList")
	public String postList(String boardid, PageVO pageVo, Model model) {
		logger.debug("pageList -- pageVo.page : {}, pageVo.pageSize : {}", pageVo.getPage(), pageVo.getPageSize());
		BoardVO board = boardService.getBoard(boardid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pageVo);
		map.put("boardid", boardid);
		Map<String, Object> postMap = postService.getPostListPage(map);
		model.addAttribute("postMap", postMap);
		model.addAttribute("board", board);
		return "/post/postList.jsp";
	}
	

	
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String boardid =
	 * request.getParameter("boardid"); String boardnm =
	 * request.getParameter("boardnm"); String pagetext =
	 * request.getParameter("page"); logger.debug("page : {}",pagetext); String
	 * pagesizetext = request.getParameter("pagesize");
	 * logger.debug("pagesize : {}",pagesizetext);
	 * 
	 * int page = 1; int pagesize = 10;
	 * 
	 * if(pagetext != null) { page = Integer.parseInt(pagetext); }
	 * 
	 * if(pagesizetext !=null) { pagesize = Integer.parseInt(pagesizetext); }
	 * 
	 * 
	 * BoardVO board = boardService.getBoard(boardid);
	 * 
	 * 
	 * PageVO pageVo = new PageVO(page, pagesize);
	 * 
	 * Map<String, Object> map = new HashMap<>();
	 * 
	 * map.put("page", pageVo); map.put("boardid", boardid);
	 * 
	 * Map<String, Object> postMap = postService.getPostListPage(map); List<PostVO>
	 * postList = (List<PostVO>)postMap.get("postList");
	 * 
	 * request.setAttribute("board", board); request.setAttribute("pageVo", pageVo);
	 * request.setAttribute("postMap", postMap); request.setAttribute("boardid",
	 * boardid); request.setAttribute("boardnm", boardnm);
	 * request.setAttribute("totalPage", postMap.get("totalPage"));
	 * logger.debug("totalPage : {}", postMap.get("totalPage"));
	 * request.setAttribute("postList", postMap.get("postList"));
	 * 
	 * request.getRequestDispatcher("/post/postList.jsp").forward(request,
	 * response);
	 * 
	 * }
	 */

}
