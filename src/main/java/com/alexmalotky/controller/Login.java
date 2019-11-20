package com.alexmalotky.controller;


import com.alexmalotky.util.LoginServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet( urlPatterns = {"/Login"} )
public class Login extends LoginServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkForLogin(request);
        response.sendRedirect(request.getHeader("referer"));
        //TODO: redirect to account instead of index
    }
}
