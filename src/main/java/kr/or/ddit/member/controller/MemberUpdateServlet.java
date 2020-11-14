package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate")
@MultipartConfig
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberServiceI memberService;
    private static final Logger logger = LoggerFactory.getLogger(MemberUpdateServlet.class);
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		memberService = new MemberService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		MemberVO memberVo = memberService.getMember(userId);
		System.out.println(memberVo.getUserId());
		request.setAttribute("memberVo", memberVo);
		request.getRequestDispatcher("/member/memberUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String userNm = request.getParameter("userNm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		String realFileName = request.getParameter("originfilename");
		String fileName = request.getParameter("filename");
		
		logger.debug("{}, {}, {}, {}, {}, {}, {}", 
				userId, userNm, alias, pass, addr1, addr2, zipcode);
		
		Part profile = request.getPart("realFileName");
		
		//새로운 파일을 전송했을 때
		if(profile.getSize() > 0) {
			realFileName = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
			// profile.getHeader("Content-Disposition") : form-data; name="전송 시 설정한 이름"; filename="sally.png" 
			logger.debug("file : {}",profile.getHeader("Content-Disposition"));
		}
		
		//확장자 가져오기 (구분자 포함하여 가져옴)
		String extension = FileUploadUtil.getExtension(realFileName);
		// 기존 파일의 fileName이 경로와 확장자를 포함 하므로 기존의 값으로 초기화
		String filePath = fileName;
		// 파일이 전송되었을 때 파일명은 중복방지를 위해 랜덤한 문자열로 바꾸고 파일 경로와 확장자를 덧붙여 db에 저장할 값을 만들어 줌.
		if(profile.getSize() > 0) {
			fileName = UUID.randomUUID().toString();
			filePath = "D:\\profile\\" + fileName + extension;
			profile.write(filePath);	// 전송한 파일을 서버 디스크에 저장 파일 경로는 MultipartConfig에서 설정.
		}
		
		//사용자 정보 등록
		MemberVO memberVo = new MemberVO(userId, userNm, pass, alias, addr1, addr2, zipcode,
				realFileName, filePath);
		
		
		int updateCnt = memberService.updateMember(memberVo);
		
		//1건이 입력되었을 때 : 정상 - memberList 페이지로 이동
		if(updateCnt == 1) {
			
			//서버의 상태가 바뀔때는 redirect를 사용한다.(새로 고침을 할 필요가 있는 경우 안그러면 기존 값으로 출력하는 경우가 있음.)
			response.sendRedirect(request.getContextPath()+"/member?userId="+userId);
		}
		//1건이 아닐때 : 비정상 - 사용자가 데이터를 다시 입력할 수 있도록 등록페이지로 이동
		else{
			doGet(request, response);
		}
	}

}
