package com.github.AlGrom13.login.servlet;

import com.github.AlGrom13.login.RegistrationService;
import com.github.AlGrom13.login.impl.DefaultRegistrationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    private RegistrationService registrationService = DefaultRegistrationService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
