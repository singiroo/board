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
public class ReplUpdateServlet{
    private static final Logger logger = LoggerFactory.getLogger(ReplUpdateServlet.class);
    
    @Resource(name = "replService")
    private ReplServiceI replService;
    

	@RequestMapping(path = "/replUpdate", method = {RequestMethod.POST})
    public String replUpdate(ReplVO replVo) {
		String postid = replService.updateRepl(replVo);
		return "redirect:/post?postid="+postid;
		
	}
    
    
    
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * request.setCharacterEncoding("utf-8"); String replid =
	 * request.getParameter("replid"); String replcont =
	 * request.getParameter("replUpdCont"); ReplVO replVo = new ReplVO(replid, null,
	 * replcont, null, null, null, null);
	 * 
	 * String postid = replService.updateRepl(replVo);
	 * 
	 * if(postid != null) {
	 * response.sendRedirect(request.getContextPath()+"/post?postid="+postid); }
	 * else {
	 * response.sendRedirect(request.getContextPath()+"/post?postid="+postid); } }
	 */

}
