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
@WebServlet("/profileImg")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ProfileServlet.class);
	private MemberServiceI memberService;
	
	@Override
		public void init() throws ServletException {
			memberService = new MemberService();
		}
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자 아이디를 전송받아 db로 부터 사용자의 정보를 받아옴
		// db에서 받아온 자료 중 프로필 이미지 파일의 파일 이름 정보와 파일 경로 정보를 이용하여 서버 디스크에 저장된 파일을 읽어서 클라이언트인 브라우저에 전송
		// MIME 타입이 image 이므로 이미지 출력 결과가 됨.
		
		
		//사용자 아이디 파라미터 확인하고
		response.setContentType("image/png");
		String userId = request.getParameter("userId");
		System.out.println(userId);
		//db에서 사용자 filename확인
		MemberVO memberVo = memberService.getMember(userId);
		
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



