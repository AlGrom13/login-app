package com.github.AlGrom13.login.servlet;

import com.github.AlGrom13.login.WebUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().removeAttribute("authUser");
        req.getSession().invalidate();
        WebUtils.forward("login", req, resp);
    }

}