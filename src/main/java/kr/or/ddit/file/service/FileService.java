package kr.or.ddit.file.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.file.dao.FileDaoI;
import kr.or.ddit.file.model.AttachFileVO;

@Service("fileService")
public class FileService implements FileServiceI {
	
	private static final Logger logger = LoggerFactory.getLogger(FileService.class);
	
	@Resource(name = "fileDao")
	private FileDaoI fileDao;
	

	@Override
	public AttachFileVO getFile(String fileid) {
		return fileDao.getFile(fileid);
	}

}
