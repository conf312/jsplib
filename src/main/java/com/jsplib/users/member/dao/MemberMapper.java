package com.jsplib.users.member.dao;

import com.jsplib.users.member.dto.MemberResponseDto;
import com.jsplib.users.member.dto.MemberSignupRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public int insertMember(MemberSignupRequestDto memberSignupRequestDto);
    public MemberResponseDto selectMember(String email);
    public int updatePassword(MemberSignupRequestDto memberSignupRequestDto);
    public int deleteMember(String email);
}
