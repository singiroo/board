package kr.or.ddit.file.service;

import kr.or.ddit.file.model.AttachFileVO;

public interface FileServiceI {
	
	
	/**
	 * 첨부파일의 아이디를 입력받아 파일의 정보를 가져오는 메서드
	 * @param fileid		첨부파일의 아이디
	 * @return				파일의 정보를 담은 VO객체
	 */
	public AttachFileVO getFile(String fileid);

}
