package com.github.AlGrom13.login.servlet;

import com.github.AlGrom13.login.RegistrationService;
import com.github.AlGrom13.login.WebUtils;
import com.github.AlGrom13.login.impl.DefaultRegistrationService;
import com.github.AlGrom13.login.model.AuthUser;
import com.github.AlGrom13.login.model.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private RegistrationService registrationService = DefaultRegistrationService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        WebUtils.forward("reg_form", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        AuthUser user = new AuthUser(login, password, Role.USER);
        if (registrationService.registerUser(user)) {
            req.getSession().setAttribute("authUser", user);
        } else {
            req.setAttribute("error", "login is already registered");
            WebUtils.forward("reg_form", req, resp);
        }
        try {
            resp.sendRedirect(req.getContextPath() + "/workspace");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
