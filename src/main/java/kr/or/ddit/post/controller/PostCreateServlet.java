package kr.or.ddit.post.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.file.model.AttachFileVO;
import kr.or.ddit.file.util.FileUploadUtil;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.post.service.PostServiceI;


@Controller
public class PostCreateServlet{
	private static final Logger logger = LoggerFactory.getLogger(PostCreateServlet.class);
	
	@Resource(name = "postService")
	private PostServiceI postService;
    
	
	@GetMapping("/postCreate")
	public String postCreateView(PostVO postVo, Model model) {
		logger.debug("boardid : {}", postVo.getBoardid());
		model.addAttribute("post", postVo);
		return "/post/postCreate.jsp";
	}
	
	@PostMapping("/postCreate")
	public String postCreate(PostVO postVo, @RequestPart("attachfile") MultipartFile[] files){
		logger.debug("postCreate method");
		logger.debug("postVo : {}", postVo);
		Map<String, Object> map = new HashedMap<String, Object>();
		List<AttachFileVO> fileList = new ArrayList<AttachFileVO>();
		String path = "D:\\upload\\";
		new File(path).mkdirs();
		AttachFileVO attach = null;
		for(MultipartFile file : files) {
			//logger.debug("files : {}", file.getOriginalFilename());
			if(file.getSize() > 0) {
				String ext = FileUploadUtil.getExtension(file.getOriginalFilename());
				String fakename = UUID.randomUUID().toString();
				String filePath = path + fakename + ext;
				try {
					file.transferTo(new File(filePath));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				attach = new AttachFileVO(null, filePath, file.getOriginalFilename(), null);
				fileList.add(attach);
			}
		}
		
		map.put("postVo", postVo);
		map.put("fileList", fileList);
		postService.insertPost(map);
		//return "";
		return "redirect:/postList?boardid="+postVo.getBoardid();
	}
   


	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String boardid =
	 * request.getParameter("boardid"); String parentid =
	 * request.getParameter("parentid"); request.setAttribute("boardid", boardid);
	 * request.setAttribute("parentid", parentid);
	 * request.getRequestDispatcher("/post/postCreate.jsp").forward(request,
	 * response); }
	 */

	
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * request.setCharacterEncoding("utf-8"); String userid =
	 * request.getParameter("userid"); String boardid =
	 * request.getParameter("boardid"); String parentid =
	 * request.getParameter("parentid"); String title =
	 * request.getParameter("title"); String cont = request.getParameter("cont");
	 * logger.debug("boardid : {}",boardid); logger.debug("userid : {}",userid);
	 * logger.debug("parentid : {}",parentid); logger.debug("title : {}",title);
	 * logger.debug("cont : {}",cont);
	 * 
	 * PostVO postVo = new PostVO(boardid, null, parentid, title, cont, null, "T",
	 * userid);
	 * 
	 * List<Part> filePartList = new ArrayList<>(request.getParts());
	 * List<AttachFileVO> fileList = new ArrayList<>(); String path =
	 * "D:\\upload\\"; new File(path).mkdirs();
	 * 
	 * for(Part filePart : filePartList) {
	 * if(filePart.getHeader("Content-Disposition").indexOf("filename")!=-1 &&
	 * filePart.getHeader("Content-disposition").indexOf("name=\"files\"") == -1) {
	 * if(filePart.getSize() > 0) { logger.debug(filePart.getContentType());
	 * logger.debug("files content-disposition : {}",filePart.getHeader(
	 * "Content-Disposition")); String realfilename =
	 * FileUploadUtil.getFilename(filePart.getHeader("Content-Disposition"));
	 * logger.debug("filename : {}",realfilename); String extension =
	 * FileUploadUtil.getExtension(realfilename);
	 * logger.debug("extension : {}",extension); String filename =
	 * UUID.randomUUID().toString(); logger.debug("uuid : {}",filename); String
	 * filePath =""; filePath = path + filename + extension;
	 * filePart.write(filePath); filePart.delete(); AttachFileVO file = new
	 * AttachFileVO(null, filePath, realfilename, null); fileList.add(file); } } }
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * 
	 * map.put("postVo", postVo); map.put("fileList", fileList);
	 * 
	 * int cnt = postService.insertPost(map);
	 * 
	 * response.sendRedirect(request.getContextPath()+"/postList?boardid="+boardid);
	 * 
	 * }
	 */

}
