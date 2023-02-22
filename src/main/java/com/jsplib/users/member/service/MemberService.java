package com.jsplib.users.member.service;

import com.jsplib.users.member.dao.MemberMapper;
import com.jsplib.users.member.dto.MemberResponseDto;
import com.jsplib.users.member.dto.MemberSignupRequestDto;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public int insertMember(MemberSignupRequestDto memberSignupRequestDto) {
        return memberMapper.insertMember(memberSignupRequestDto);
    }

    public MemberResponseDto selectMember(String email) {
        return memberMapper.selectMember(email);
    }

    public int updatePassword(MemberSignupRequestDto memberSignupRequestDto) {
        return memberMapper.updatePassword(memberSignupRequestDto);
    }

    public int deleteMember(String email) {
        return memberMapper.deleteMember(email);
    }
}
