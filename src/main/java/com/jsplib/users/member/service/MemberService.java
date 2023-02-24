package com.jsplib.users.member.service;

import com.jsplib.users.member.dao.MemberMapper;
import com.jsplib.users.member.dto.MemberResponseDto;
import com.jsplib.users.member.dto.MemberSignupRequestDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements UserDetailsService {
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MemberResponseDto member = memberMapper.selectMember(email);

        if (member == null) throw new UsernameNotFoundException("Not Found account.");

        return member;
    }

    public int insertMember(MemberSignupRequestDto memberSignupRequestDto) {
        memberSignupRequestDto.setPassword(new BCryptPasswordEncoder().encode(memberSignupRequestDto.getPassword()));
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
