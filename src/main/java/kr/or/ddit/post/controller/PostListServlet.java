package kr.or.ddit.post.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;

/**
 * Servlet implementation class PostListServlet
 */
@WebServlet("/postList")
public class PostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostListServlet.class);
	private PostServiceI postService;
	private BoardServiceI boardService;
       
    

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		postService = new PostService();
		boardService = new BoardService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardid = request.getParameter("boardid");
		String boardnm = request.getParameter("boardnm");
		String pagetext = request.getParameter("page");
		logger.debug("page : {}",pagetext);
		String pagesizetext = request.getParameter("pagesize");
		logger.debug("pagesize : {}",pagesizetext);
		
		int page = 1;
		int pagesize = 10;
		
		if(pagetext != null) {
			page = Integer.parseInt(pagetext);
		}
		
		if(pagesizetext !=null) {
			pagesize = Integer.parseInt(pagesizetext);
		}
		
		
		BoardVO board = boardService.getBoard(boardid);
		
		
		PageVO pageVo = new PageVO(page, pagesize);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("page", pageVo);
		map.put("boardid", boardid);
		
		Map<String, Object> postMap = postService.getPostListPage(map);
		List<PostVO> postList = (List<PostVO>)postMap.get("postList");
		
		request.setAttribute("board", board);
		request.setAttribute("pageVo", pageVo); 
		request.setAttribute("postMap", postMap);
		request.setAttribute("boardid", boardid);
		request.setAttribute("boardnm", boardnm);
		request.setAttribute("totalPage", postMap.get("totalPage"));
		logger.debug("totalPage : {}", postMap.get("totalPage"));
		request.setAttribute("postList", postMap.get("postList"));
		 
		request.getRequestDispatcher("/post/postList.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
