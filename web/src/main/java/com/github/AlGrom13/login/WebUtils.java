package com.github.AlGrom13.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtils {

    public static void forward(String page, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/" + page + ".jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
