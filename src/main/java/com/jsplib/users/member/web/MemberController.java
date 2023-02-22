package com.jsplib.users.member.web;

import com.jsplib.users.member.dto.MemberSignupRequestDto;
import com.jsplib.users.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signin")
    public String getSigninPage() {
        return "member/signin";
    }

    @GetMapping("/signup")
    public String getSignupPage() {
        return "member/signup";
    }

    @PostMapping("/signup/action")
    public String signupAction(Model model, MemberSignupRequestDto memberSignupRequestDto) {
        if (memberService.insertMember(memberSignupRequestDto) > 0)
            model.addAttribute("url", "/member/signin");
        return "error/blank";
    }
}

