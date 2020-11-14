package kr.or.ddit.member.controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profileDownload")
public class ProfileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ProfileDownloadServlet.class);
	private MemberServiceI memberService;
	
	@Override
		public void init() throws ServletException {
			memberService = new MemberService();
		}
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/octet-stream");
		
		//사용자 아이디 파라미터 확인하고
		String userId = request.getParameter("userId");
		//db에서 사용자 filename확인
		MemberVO memberVo = memberService.getMember(userId);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + memberVo.getRealFileName()+"\"");
		
		//경로 확인 후 파일 입출력을 통해 응답생성
		//  파일 읽기
		//  응답 생성
		String path = memberVo.getFileName();
		String realPath = "D:\\profile\\"+memberVo.getRealFileName();
		
		logger.debug("path : {}",path);//파일 경로
		logger.debug("realPath : {}", realPath);
		
		if(path.equals(realPath)) {
			System.out.println("same!!!");
		}else {
			System.out.println("differ!");
		}
		
		
		
		
		//다운로드 : db에 저장된 파일이름으로 서버의 디스크로부터 버퍼 크기 만큼 읽어와 클라이언트(웹 브라우저)에게 전송 
		
		FileInputStream fis = new FileInputStream(memberVo.getFileName());
		
		
		
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		while(fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		
		fis.close();
		sos.flush();
		sos.close();
	}

}



