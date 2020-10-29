package kr.or.ddit.file.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import kr.or.ddit.file.model.AttachFileVO;

public class FileDaoTest {
	private FileDaoI fileDao;

	@Test
	public void getFileTest() {
		/***Given***/
		fileDao = new FileDao();
		String fileid = "8";
		String realfilename = "brown.png";
		/***When***/
		AttachFileVO file = new AttachFileVO();
		try {
			file = fileDao.getFile(fileid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/***Then***/
		assertEquals(realfilename, file.getRealfilename());
	}

}
