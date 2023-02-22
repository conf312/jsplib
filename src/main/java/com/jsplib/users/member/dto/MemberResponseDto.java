package com.jsplib.users.member.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {
    private Long idx;
    private String name;
    private String email;
    private String password;
    private String registerTime;
}
