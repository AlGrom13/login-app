package com.github.AlGrom13.login.servlet;

import com.github.AlGrom13.login.SecurityService;
import com.github.AlGrom13.login.WebUtils;
import com.github.AlGrom13.login.impl.DefaultSecurityService;
import com.github.AlGrom13.login.model.AuthUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private SecurityService securityService = DefaultSecurityService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        AuthUser user = securityService.login(login, password);
        if (user == null) {
            req.setAttribute("error", "login or password invalid");
            WebUtils.forward("login", req, resp);
        }
        req.getSession().setAttribute("authUser", user);
        try {
            resp.sendRedirect(req.getContextPath() +"/workspace");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
