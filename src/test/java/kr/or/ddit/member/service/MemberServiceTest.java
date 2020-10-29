package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {
	private MemberServiceI memberService;

	@Test
	public void getMemberTest() {
		/***Given***/
		memberService = new MemberService();
		String userid = "brown";
		String password = "brownPass";
		
		/***When***/
		MemberVO memberVo = memberService.getMember(userid);
		
		/***Then***/
		
		assertEquals(password, memberVo.getPass());

	}

}
