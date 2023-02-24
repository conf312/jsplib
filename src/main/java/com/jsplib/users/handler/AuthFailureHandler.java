package com.jsplib.users.handler;

import com.jsplib.users.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final MemberService memberService;

    public AuthFailureHandler(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("==> onAuthenticationFailure");
        String email= request.getParameter("email");
        String msg = "msg.member.not.match";

        if (exception instanceof DisabledException) {
            msg = "msg.member.not.enabled";
        } else if (exception instanceof CredentialsExpiredException) {
            msg = "msg.member.not.credentialsExpired";
        } else if (exception instanceof LockedException) {
            msg = "msg.member.not.accountLocked";
        }

        //memberService.updateLoginFailCount(email);

        setDefaultFailureUrl("/member/signin?msg=" + msg + "&email=" + email);
        super.onAuthenticationFailure(request, response, exception);
    }
}