package com.jsplib.users.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberSignupRequestDto {
    private Long idx;
    private String name;
    private String email;
    private String password;
}
