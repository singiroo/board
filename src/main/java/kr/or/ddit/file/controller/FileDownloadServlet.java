package kr.or.ddit.file.controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.file.model.AttachFileVO;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.file.service.FileServiceI;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FileDownloadServlet.class);
	private FileServiceI fileService;
       

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		fileService = new FileService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/octet-stream");
		String fileid = request.getParameter("fileid");
		
		AttachFileVO fileVo = fileService.getFile(fileid);
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileVo.getRealfilename()+"\"");
		
		String path = fileVo.getFilenm();
		
		FileInputStream fis = new FileInputStream(path);
		
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		while(fis.read(buffer)!=-1) {
			sos.write(buffer);
		}
		
		fis.close();
		sos.flush();
		sos.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
