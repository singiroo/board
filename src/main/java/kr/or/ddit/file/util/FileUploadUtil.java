package kr.or.ddit.file.util;

public class FileUploadUtil {
	
	//contentDisposition 헤더값을 받아 파일 이름을 잘라내는 메서드
	public static String getFilename(String contentDisposition) {
		String[] splitArr = contentDisposition.split("; ");
		String result = "";
		
		for(String splitString : splitArr) {
			String[] resultArr = splitString.split("=");
			if("filename".equals(resultArr[0])) {
				result = resultArr[1].replaceAll("\"", "");
			}
		}
		
		return result;
	}
	// 확장자 (구분자 포함) 추출 메서드 : filename : sally.png ==> .png
	public static String getExtension(String filename) {
		String extension = "";
		String[] fileStrArr = null;
		
		if(filename != null || filename.indexOf(".") != -1) {
			extension = filename.substring(filename.lastIndexOf("."));
		}
		
		return extension;
	}
	
}
