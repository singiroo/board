package kr.or.ddit.file.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.file.model.AttachFileVO;

@Repository("fileDao")
public class FileDao implements FileDaoI {
	
	private static final Logger logger = LoggerFactory.getLogger(FileDao.class);
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public AttachFileVO getFile(String fileid){
		return sqlSession.selectOne("file.getFile", fileid);
	}

}
