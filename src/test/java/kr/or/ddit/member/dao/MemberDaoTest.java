package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {
	private MemberDaoI memberDao;
	
	@Test
	public void getMemberTest() {
		/***Given***/
		memberDao = new MemberDao();
		String userid = "brown";
		String userpass = "brownPass";
		/***When***/
		MemberVO memberVo = memberDao.getMember(userid);
		/***Then***/
		assertEquals(userpass, memberVo.getPass());
		
	}

}
