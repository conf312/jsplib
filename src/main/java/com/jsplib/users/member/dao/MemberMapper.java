package com.jsplib.users.member.dao;

import com.jsplib.users.member.dto.MemberSignupRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public int insertMember(MemberSignupRequestDto memberSignupRequestDto);
}
