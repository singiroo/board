package kr.or.ddit.repl.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.repl.model.ReplVO;
import kr.or.ddit.repl.service.ReplServiceI;


@Controller
public class ReplCreateServlet{
	private static final Logger logger = LoggerFactory.getLogger(ReplCreateServlet.class);
	
	@Resource(name = "replService")
    private ReplServiceI replService;   
   
	@RequestMapping(path = "/replCreate", method = {RequestMethod.POST})
	public String createRepl(ReplVO replVo) {
		replService.insertRepl(replVo);
		return "redirect:/post?postid="+replVo.getPostid();
	}


	/*
	 * void doPost(HttpServletRequest request, HttpServletResponse response) throws
	 * ServletException, IOException { request.setCharacterEncoding("utf-8"); String
	 * postid = request.getParameter("postid"); String userid =
	 * request.getParameter("repluserid"); String title =
	 * request.getParameter("repltitle"); String cont =
	 * request.getParameter("replcont");
	 * 
	 * 
	 * ReplVO repl = new ReplVO(null, postid, cont, null, title, null, userid);
	 * 
	 * logger.debug("repl : {}", repl.toString()); int cnt =
	 * replService.insertRepl(repl);
	 * 
	 * if(cnt == 1) {
	 * response.sendRedirect(request.getContextPath()+"/post?postid="+postid); }
	 * else { //에러페이지 생성
	 * response.sendRedirect(request.getContextPath()+"/post?postid="+postid); }
	 * 
	 * }
	 */

}
