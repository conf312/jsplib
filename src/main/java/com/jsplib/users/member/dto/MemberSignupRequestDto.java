package com.jsplib.users.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberSignupRequestDto {
    private String name;
    private String email;
    private String password;
}
