package kr.co.leehana.service;

import kr.co.leehana.model.Member;

/**
 * @author Hana Lee
 * @since 2015-11-14 03-29
 */
public interface MemberService {
	Member getMember(String userId) throws Exception;
}
