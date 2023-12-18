package com.webtech.webtechProject.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_TRAINEE")) {
                response.sendRedirect("/userDash");
                return;
            } else if (authority.getAuthority().equals("ROLE_TRAINER")) {
                response.sendRedirect("/trainerdash");
                return;
            }
        }

        // Default redirect if no matching role is found
        response.sendRedirect("/landing");
    }
}
