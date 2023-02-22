package com.jsplib.users.member.dao;

import lombok.Getter;

@Getter
public class MemberEntity {
    private Long idx;
    private String name;
    private String email;
    private String password;
    private String registerTime;
}
