package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

@Service("memberService")
public class MemberService implements MemberServiceI {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Resource(name = "memberDao")
	private MemberDaoI memberDao;
	

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
		return memberDao.selectMemberPageList(pageVo);
	}
	
	
	@Override
	public Map<String, Object> selectPagingComponent(PageVO pageVo) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("memberList", memberDao.selectMemberPageList(pageVo));
		
		int totalCnt = memberDao.selectMemberTotalCnt();
		
		int totalPage = (int)(Math.ceil((double)totalCnt/pageVo.getPageSize()));
		
		map.put("totalPage", totalPage);
		
		return map;
	}


	@Override
	public int insertMember(MemberVO memberVo) {
		return memberDao.insertMember(memberVo);
	}


	@Override
	public int deleteMember(String userId) {
		return memberDao.deleteMember(userId);
	}


	@Override
	public int updateMember(MemberVO memberVo) {
		return memberDao.updateMember(memberVo);
	}


	
	

}
