package kr.co.leehana.controller;

import kr.co.leehana.model.Member;
import kr.co.leehana.service.MemberService;

/**
 * @author Hana Lee
 * @since 2015-11-14 04-01
 */
public class LoginController {

	private MemberService memberService;

	public LoginController(MemberService memberService) {
		this.memberService = memberService;
	}

	public boolean loginCheck(String userId, String password) throws Exception {
		Member member = memberService.getMember(userId);
		if (member == null) {
			return false;
		} else if (!member.getPassword().equals(password)) {
			return false;
		}

		return true;
	}
}
