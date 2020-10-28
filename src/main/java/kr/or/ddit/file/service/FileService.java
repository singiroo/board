package kr.or.ddit.file.service;

import java.sql.SQLException;

import kr.or.ddit.file.dao.FileDao;
import kr.or.ddit.file.dao.FileDaoI;
import kr.or.ddit.file.model.AttachFileVO;

public class FileService implements FileServiceI {
	
	private FileDaoI fileDao;
	
	
	
	
	
	@Override
	public AttachFileVO getFile(String fileid) {
		fileDao = new FileDao();
		AttachFileVO file = null;
		try {
			file = fileDao.getFile(fileid);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return file;
	}

}
