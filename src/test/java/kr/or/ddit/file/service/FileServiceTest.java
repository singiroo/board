package kr.or.ddit.file.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.file.model.AttachFileVO;

public class FileServiceTest extends ModelTestConfig{

	@Resource(name = "fileService")
	private FileServiceI fileService;
	
	@Test
	public void getFileTest() {
		/***Given***/
		String fileid = "file87";
		/***When***/
		AttachFileVO file = fileService.getFile(fileid);
		/***Then***/
		assertEquals("memObj.bin", file.getRealfilename());
	}

}
