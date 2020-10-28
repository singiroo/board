package kr.or.ddit.post.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import kr.or.ddit.file.model.AttachFileVO;
import kr.or.ddit.file.util.FileUploadUtil;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;

/**
 * Servlet implementation class PostCreateServlet
 */
@WebServlet("/postCreate")
@MultipartConfig
public class PostCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostCreateServlet.class);
	private PostServiceI postService;
       
   

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		postService = new PostService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardid = request.getParameter("boardid");
		String parentid = request.getParameter("parentid");
		request.setAttribute("boardid", boardid);
		request.setAttribute("parentid", parentid);
		request.getRequestDispatcher("/post/postCreate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String boardid = request.getParameter("boardid");
		String parentid = request.getParameter("parentid");
		String title = request.getParameter("title");
		String cont = request.getParameter("cont");
		logger.debug("boardid : {}",boardid);
		logger.debug("userid : {}",userid);
		logger.debug("parentid : {}",parentid);
		logger.debug("title : {}",title);
		logger.debug("cont : {}",cont);
		
		PostVO postVo = new PostVO(boardid, null, parentid, title, cont, null, "T", userid);
		
		List<Part> filePartList = new ArrayList<>(request.getParts());
		List<AttachFileVO> fileList = new ArrayList<>();
		String path = "D:\\upload\\";
		new File(path).mkdirs();
		
		for(Part filePart : filePartList) {
			if(filePart.getHeader("Content-Disposition").indexOf("filename")!=-1) {
				logger.debug(filePart.getContentType());
				logger.debug("files content-disposition : {}",filePart.getHeader("Content-Disposition"));
				String realfilename = FileUploadUtil.getFilename(filePart.getHeader("Content-Disposition"));
				logger.debug("filename : {}",realfilename);
				String extension = FileUploadUtil.getExtension(realfilename);
				logger.debug("extension : {}",extension);
				String filename = UUID.randomUUID().toString();
				logger.debug("uuid : {}",filename);
				String filePath ="";
				if(filePart.getSize() > 0) {
					filePath = path + filename + extension;
					filePart.write(filePath);
					filePart.delete();
				}
				AttachFileVO file = new AttachFileVO(null, filePath, realfilename, null);
				fileList.add(file);				
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("postVo", postVo);
		map.put("fileList", fileList);
		
		int cnt = postService.insertPost(map);
		
		response.sendRedirect(request.getContextPath()+"/postList?boardid="+boardid);
		
	}

}
