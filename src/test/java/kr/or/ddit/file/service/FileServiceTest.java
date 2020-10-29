package kr.or.ddit.file.service;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.file.model.AttachFileVO;

public class FileServiceTest {
	private FileServiceI fileService;

	@Test
	public void getFileTest() {
		/***Given***/
		fileService = new FileService();
		String fileid = "8";
		String realfilename = "brown.png";
		/***When***/
		AttachFileVO file = fileService.getFile(fileid);
		/***Then***/
		assertEquals(realfilename, file.getRealfilename());
	}

}
