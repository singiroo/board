package kr.or.ddit.file.dao;

import java.sql.SQLException;

import kr.or.ddit.file.model.AttachFileVO;

public interface FileDaoI {
	
	/**
	 * 첨부파일의 아이디를 입력받아 파일 정보를 가져오는 메서드
	 * @param fileid			첨부파일의 아이디
	 * @return					파일의 정보를 담은 VO객체
	 * @throws SQLException
	 */
	public AttachFileVO getFile(String fileid);

}
