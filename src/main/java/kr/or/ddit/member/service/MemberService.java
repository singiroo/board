package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

public class MemberService implements MemberServiceI {
	
	private MemberDaoI memberDao;
	private SqlSession sqlSession;           // sqlSession을 만드는 것은 연결을 생성하는 것으로 시스템 부하가 많이 걸림.
	                                         // 따라서 dao에서 SqlSession 객체를 생성하여 만들면 트랜잭션 단위가 아닌 dao 메서드 단위로 연결이 생성되어
											 // 부하가 너무 심해짐에 따라 service 단에서 트랜잭션단위로 SqlSession 객체를 생성한다.
	                                         // 또한 같은 트랜잭션에서는 같은 연결을 사용하는 것이 로직적으로 바람직하다.
											 // dao 단에서 세부 작업별로 SqlSession을 생성하는 것은 마치 developer 창을 여러개 띄워놓고 작업하는 것과 같음.
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	

	@Override
	public MemberVO getMember(String userId) {
		return memberDao.getMember(userId);
	}


	@Override
	public List<MemberVO> selectAllMember() {
		return memberDao.selectAllMember();
	}
	
	
	@Override
	public List<MemberVO> selectMemberPageList(PageVO pageVo) {
		sqlSession = MybatisUtil.getSqlSession();
		List<MemberVO> memberList = memberDao.selectMemberPageList(sqlSession, pageVo);
		sqlSession.close();
		return memberList;
	}
	
	
	@Override
	public Map<String, Object> selectPagingComponent(PageVO pageVo) {
		sqlSession = MybatisUtil.getSqlSession();
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("memberList", memberDao.selectMemberPageList(sqlSession, pageVo));
		
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);
		
		int totalPage = (int)(Math.ceil((double)totalCnt/pageVo.getPageSize()));
		
		map.put("totalPage", totalPage);
		sqlSession.close();
		return map;
	}


	@Override
	public int insertMember(MemberVO memberVo) {
		int insertCnt = memberDao.insertMember(memberVo);
		return insertCnt;
	}


	@Override
	public int deleteMember(String userId) {
		int deleteCnt = memberDao.deleteMember(userId);
		return deleteCnt;
	}


	@Override
	public int updateMember(MemberVO memberVo) {
		int updateCnt = memberDao.updateMember(memberVo);
		return updateCnt;
	}


	
	

}
