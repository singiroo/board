package kr.or.ddit.repl.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.repl.model.ReplVO;
import kr.or.ddit.repl.service.ReplServiceI;


@Controller
public class ReplDeleteServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(ReplDeleteServlet.class);
	
	@Resource(name = "replService")
	private ReplServiceI replService;
       
	
	@RequestMapping("/replDelete")
	public String replDelete(ReplVO replVo) {
		String postid = replService.deleteRepl(replVo);
		return "redirect:/post?postid="+postid;
	}
	
	
	
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String replid =
	 * request.getParameter("replid"); ReplVO repl = new ReplVO(replid, null, null,
	 * null, null, null, null); String postid = replService.deleteRepl(repl);
	 * 
	 * if(postid != null) {
	 * response.sendRedirect(request.getContextPath()+"/post?postid="+postid); }else
	 * { response.sendRedirect(request.getContextPath()+"/post?postid="+postid); }
	 * 
	 * 
	 * 
	 * }
	 */

}
