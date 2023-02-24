package com.jsplib.users.handler;

import com.jsplib.users.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberService memberService;

    public AuthSuccessHandler(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        log.info("==> onAuthenticationSuccess");
        response.sendRedirect("/book/list");
//        Member.Response member = (Member.Response) authentication.getPrincipal();
//
//        if (member.getLoginFailCount() > 4) {
//            memberService.updateCredentialsNonExpired(member.getId(), "N");
//            response.sendRedirect("/member/public/login?msg=msg.member.not.credentialsExpired&email=" + member.getEmail());
//        } else if (member.isEnabled() && member.isCredentialsNonExpired() && member.isAccountNonLocked()) {
//            memberService.updateLastLoginTime(member.getId(), AuthorizationUtil.getClientIp(request));
//            RequestContextHolder.getRequestAttributes().setAttribute("member", member, RequestAttributes.SCOPE_SESSION);
//            response.sendRedirect("/dashboard");
//        }
    }
}