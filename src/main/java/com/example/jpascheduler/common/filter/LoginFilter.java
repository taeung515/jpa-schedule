package com.example.jpascheduler.common.filter;

import com.example.jpascheduler.common.exception.LoginRequiredException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

import static com.example.jpascheduler.common.constant.Constants.*;

/**
 * 로그인 인증을 하는 필터입니다.
 * 회원가입, 로그인 경로를 제외하고 접근하는 모든 경로에서 세션이 없는 유저의 접근을 차단합니다.
 */
public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/api/users/signup", "/api/users/login"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (!isWhiteList(requestURI)) {

            HttpSession session = httpRequest.getSession(false);

            if (session == null || session.getAttribute(SESSION_USER_ID) == null) {
                throw new LoginRequiredException("로그인 해주세요");
            }

        }
        filterChain.doFilter(request, response);
    }

    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
