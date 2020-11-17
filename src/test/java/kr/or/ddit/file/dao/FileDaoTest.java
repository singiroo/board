package kr.or.ddit.file.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.file.model.AttachFileVO;

public class FileDaoTest extends ModelTestConfig {
	
	@Resource(name = "fileDao")
	private FileDaoI fileDao;
	
	@Test
	public void getFileTest() {
		/***Given***/
		String fileid = "file87";
		/***When***/
		AttachFileVO file = fileDao.getFile(fileid);
		/***Then***/
		assertEquals("memObj.bin", file.getRealfilename());
	}

}
