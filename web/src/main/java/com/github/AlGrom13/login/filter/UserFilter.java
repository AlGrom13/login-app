package com.github.AlGrom13.login.filter;

import com.github.AlGrom13.login.WebUtils;
import com.github.AlGrom13.login.model.AuthUser;
import com.github.AlGrom13.login.model.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/workspace")
public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        AuthUser authUser = (AuthUser) request.getSession().getAttribute("authUser");
        if (authUser.getRole().equals(Role.USER)) {
            WebUtils.forward("hello",request, (HttpServletResponse) servletResponse);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
