package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberServiceI memberService;
	
    @Override
    public void init() throws ServletException {
    	memberService = new MemberService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageText = request.getParameter("page");
		String pageSizeText = request.getParameter("pageSize");
		
		int page = 1;
		int pageSize = 5;
		
		if(pageText != null) {
			page = Integer.parseInt(pageText);		
		}
		
		if(pageSizeText != null) {
			pageSize = Integer.parseInt(pageSizeText);
		}
		
		PageVO pageVo = new PageVO(page, pageSize);
//		pageVo.setPage(page);
//		pageVo.setPageSize(pageSize);
		
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNo", page);
		
		
//		request.setAttribute("memberList", memberList);
		Map<String, Object> map = memberService.selectPagingComponent(pageVo);
		
		request.setAttribute("map", map);
		request.setAttribute("memberList", map.get("memberList"));
		request.setAttribute("totalPage", map.get("totalPage"));
		
		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
	}

}
