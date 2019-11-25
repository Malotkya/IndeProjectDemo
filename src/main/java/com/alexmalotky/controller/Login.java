package com.alexmalotky.controller;


import com.alexmalotky.util.LoginServlet;
import com.alexmalotky.util.PasswordManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet( urlPatterns = {"/Login"} )
public class Login extends LoginServlet {

    private final Logger logger = LogManager.getLogger(Login.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkForLogin(request);
        String redirect = request.getHeader("referer");

        if( isIndexPage(redirect, request.getContextPath()) )
            redirect += "Account";

        response.sendRedirect(redirect);
    }

    private boolean isIndexPage(String targetUrl, String indexUrl) {
        int index = targetUrl.lastIndexOf(indexUrl) + indexUrl.length() + 1;
        return index >= targetUrl.length();
    }
}
