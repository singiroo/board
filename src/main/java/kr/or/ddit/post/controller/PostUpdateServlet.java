package kr.or.ddit.post.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class PostUpdateServlet
 */
@WebServlet("/postUpdate")
@MultipartConfig
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostServiceI postService;
    private static final Logger logger = LoggerFactory.getLogger(PostUpdateServlet.class);
    

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
		String postid = request.getParameter("postid");
		
		Map<String, Object> map = postService.getPost(postid);
		
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("/post/postUpdate.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String postid = request.getParameter("postid");
		String title = request.getParameter("title");
		String cont = request.getParameter("cont");
		String delString = request.getParameter("delList");

		List<String> delList = new ArrayList<>();
		
		if(delString != null) {
			String[] delArr = delString.split(" ");
			for(String file : delArr) {
				delList.add(file);
			}			
		}
		
		List<Part> partList = new ArrayList(request.getParts());
		PostVO postVo = new PostVO(null, postid, null, title, cont, null, null, null);
		
		String path = "D:\\upload\\";
		new File(path).mkdirs();
		List<AttachFileVO> fileList = new ArrayList<>();
		for(Part part : partList) {
			if(part.getHeader("Content-Disposition").indexOf("filename")!=-1
					&& part.getHeader("Content-disposition").indexOf("name=\"files\"") == -1) {
				if(part.getSize() > 0) {
					String realfilename = FileUploadUtil.getFilename(part.getHeader("Content-Disposition"));
					String extension = FileUploadUtil.getExtension(realfilename);
					String filename = UUID.randomUUID().toString();
					String filePath = "";
					filePath = path + filename + extension;
					part.write(filePath);
					part.delete();
					AttachFileVO file = new AttachFileVO(null, filePath, realfilename, postid);
					fileList.add(file);
				}
			
			}
		}
			
		Map<String, Object> map = new HashMap<>();
		
		map.put("postVo", postVo);
		map.put("fileList", fileList);
		map.put("delList", delList);
		
		int cnt = postService.updatePost(map);
		
		if(cnt == delList.size()) {
			response.sendRedirect(request.getContextPath()+"/post?postid="+postid);
		}
		else {
			doGet(request, response);
		}
		
	}

}
