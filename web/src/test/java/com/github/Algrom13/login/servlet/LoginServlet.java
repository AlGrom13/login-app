package com.github.Algrom13.login.servlet;

import com.github.AlGrom13.login.SecurityService;
import com.github.AlGrom13.login.impl.DefaultSecurityService;
import com.github.AlGrom13.login.model.AuthUser;
import com.github.AlGrom13.login.model.Role;
import com.github.Algrom13.login.WebUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private SecurityService securityService = DefaultSecurityService.getInstance();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        Object authUser = rq.getSession().getAttribute("authUser");
        if (authUser == null) {
            WebUtils.forward("login", rq, rs);
        }
        try {
            rs.sendRedirect(rq.getContextPath() +"/student");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) {
        String login = rq.getParameter("login");
        String password = rq.getParameter("password");
        AuthUser user = securityService.login(new AuthUser(login, password, Role.USER));
        if (user == null) {
            rq.setAttribute("error", "login or password invalid");
            WebUtils.forward("login", rq, rs);
        }
        rq.getSession().setAttribute("authUser", user);
        try {
            rs.sendRedirect(rq.getContextPath() +"/student");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
