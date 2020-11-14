package kr.or.ddit.file.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.file.model.AttachFileVO;

public class FileDao implements FileDaoI {
	
	private SqlSession sqlSession;
	
	
	@Override
	public AttachFileVO getFile(String fileid) throws SQLException {
		sqlSession = MybatisUtil.getSqlSession();
		AttachFileVO file = sqlSession.selectOne("file.getFile", fileid);
		sqlSession.close();
		return file;
	}

}
