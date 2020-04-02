package com.github.AlGrom13.login.servlet;

import com.github.AlGrom13.login.RegistrationService;
import com.github.AlGrom13.login.UserService;
import com.github.AlGrom13.login.WebUtils;
import com.github.AlGrom13.login.impl.DefaultRegistrationService;
import com.github.AlGrom13.login.impl.DefaultUserService;
import com.github.AlGrom13.login.model.AuthUser;
import com.github.AlGrom13.login.model.Role;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/workspace")
public class WorkspaceServlet extends HttpServlet {
    private RegistrationService registrationService = DefaultRegistrationService.getInstance();
    private UserService userService = DefaultUserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<AuthUser> users = userService.getUsers();
        req.setAttribute("users", users);
        WebUtils.forward("admin", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse rs) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        AuthUser user = new AuthUser(login, password, Role.valueOf(role.toUpperCase()));
        registrationService.registerUser(user);
        try {
            rs.sendRedirect(req.getContextPath() + "/workspace");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
