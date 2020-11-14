package kr.or.ddit.member.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

@Repository("memberDao")
public class MemberDao implements MemberDaoI {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	

	@Override
	public MemberVO getMember(String userId) {
		return sqlSession.selectOne("member.getMember", userId);		
	}

	@Override
	public List<MemberVO> selectAllMember() {
		return sqlSession.selectList("member.selectAllMember");
	}

	@Override
	public List<MemberVO> selectMemberPageList(PageVO pageVo) {
		return sqlSession.selectList("member.selectMemberPageList", pageVo);
	}

	@Override
	public int selectMemberTotalCnt() {
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVO memberVo) {
		return sqlSession.insert("member.insertMember", memberVo);
	}

	@Override
	public int deleteMember(String userId) {
		return sqlSession.delete("member.deleteMember", userId);
	}

	@Override
	public int updateMember(MemberVO memberVo) {
		return sqlSession.update("member.updateMember", memberVo);
	}

}
