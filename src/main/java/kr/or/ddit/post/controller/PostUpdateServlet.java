package kr.or.ddit.post.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.file.model.AttachFileVO;
import kr.or.ddit.file.util.FileUploadUtil;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;


@Controller
public class PostUpdateServlet{
	private static final Logger logger = LoggerFactory.getLogger(PostUpdateServlet.class);

	@Resource(name = "postService")
	private PostServiceI postService;
    

	@GetMapping("/postUpdate")
	public String postUpdateView(String postid, Model model) {
		Map<String, Object> map = postService.getPost(postid);
		model.addAttribute("map", map);
		return "/post/postUpdate.jsp";
	}
	
	@PostMapping("/postUpdate")
	public String postUpdate(PostVO postVo, String delList, @RequestPart("attachfile") MultipartFile[] files) {
		
		String[] delArr = delList.split(" ");
		List<String> delFileList = new ArrayList<String>();
		for(String delStr : delArr) {
			delFileList.add(delStr);
		}
		
		List<AttachFileVO> fileList = new ArrayList<AttachFileVO>();
		String path = "D:\\upload\\";
		new File(path).mkdirs();
		AttachFileVO attachfile = null;
		for(MultipartFile file : files) {
			if(file.getOriginalFilename() != null && !("".equals(file.getOriginalFilename()))) {
				String ext = FileUploadUtil.getExtension(file.getOriginalFilename());
				String fakename = UUID.randomUUID().toString();
				String filepath = path + fakename + ext;
				try {
					file.transferTo(new File(filepath));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				attachfile = new AttachFileVO(null, filepath, file.getOriginalFilename(), postVo.getPostid());
				fileList.add(attachfile);
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postVo", postVo);
		map.put("delList", delFileList);
		map.put("fileList", fileList);
		
		int cnt = postService.updatePost(map);
		
		return "redirect:/post?postid="+postVo.getPostid();
	}
	
	
	
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String postid = request.getParameter("postid");
//		
//		Map<String, Object> map = postService.getPost(postid);
//		
//		request.setAttribute("map", map);
//		
//		request.getRequestDispatcher("/post/postUpdate.jsp").forward(request, response);
//		
//	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		String postid = request.getParameter("postid");
//		String title = request.getParameter("title");
//		String cont = request.getParameter("cont");
//		String delString = request.getParameter("delList");
//
//		List<String> delList = new ArrayList<>();
//		
//		if(delString != null) {
//			String[] delArr = delString.split(" ");
//			for(String file : delArr) {
//				delList.add(file);
//			}			
//		}
//		
//		List<Part> partList = new ArrayList<Part>(request.getParts());
//		PostVO postVo = new PostVO(null, postid, null, title, cont, null, null, null);
//		
//		String path = "D:\\upload\\";
//		new File(path).mkdirs();
//		List<AttachFileVO> fileList = new ArrayList<>();
//		for(Part part : partList) {
//			if(part.getHeader("Content-Disposition").indexOf("filename")!=-1
//					&& part.getHeader("Content-disposition").indexOf("name=\"files\"") == -1) {
//				if(part.getSize() > 0) {
//					String realfilename = FileUploadUtil.getFilename(part.getHeader("Content-Disposition"));
//					String extension = FileUploadUtil.getExtension(realfilename);
//					String filename = UUID.randomUUID().toString();
//					String filePath = "";
//					filePath = path + filename + extension;
//					part.write(filePath);
//					part.delete();
//					AttachFileVO file = new AttachFileVO(null, filePath, realfilename, postid);
//					fileList.add(file);
//				}
//			
//			}
//		}
//			
//		Map<String, Object> map = new HashMap<>();
//		
//		map.put("postVo", postVo);
//		map.put("fileList", fileList);
//		map.put("delList", delList);
//		
//		int cnt = postService.updatePost(map);
//		
//		if(cnt == delList.size()) {
//			response.sendRedirect(request.getContextPath()+"/post?postid="+postid);
//		}
//		else {
//			doGet(request, response);
//		}
//		
//	}

}
