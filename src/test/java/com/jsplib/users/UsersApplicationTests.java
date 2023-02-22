package com.jsplib.users;

import com.jsplib.users.member.dto.MemberSignupRequestDto;
import com.jsplib.users.member.service.MemberService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Collections;

@SpringBootTest
class UsersApplicationTests {

	@Autowired
	private MemberService memberService;

	@Test
	@Order(1)
	public void 회원등록() {
		MemberSignupRequestDto memberSignupRequestDto = new MemberSignupRequestDto();
		memberSignupRequestDto.setName("tester");
		memberSignupRequestDto.setEmail("tester@gmail.com");
		memberSignupRequestDto.setPassword("password123!@#");
		Assert.notEmpty(Collections.singleton(memberService.insertMember(memberSignupRequestDto)),"Empty insertMember();");
	}

	@Test
	@Order(2)
	public void 회원조회() {
		Assert.notEmpty(Collections.singleton(memberService.selectMember("tester@gmail.com")),"Empty insertMember();");
	}

	@Test
	@Order(3)
	public void 회원비밀번호변경() {
		MemberSignupRequestDto memberSignupRequestDto = new MemberSignupRequestDto();
		memberSignupRequestDto.setPassword("update password123!@#");
		memberSignupRequestDto.setEmail("tester@gmail.com");
		Assert.notEmpty(Collections.singleton(memberService.updatePassword(memberSignupRequestDto)),"Empty insertMember();");
	}

	@Test
	@Order(4)
	public void 회원삭제() {
		Assert.notEmpty(Collections.singleton(memberService.deleteMember("tester@gmail.com")),"Empty insertMember();");
	}
}
