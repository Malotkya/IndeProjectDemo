package com.alexmalotky.controller;

import com.alexmalotky.action.Users;
import com.alexmalotky.util.LoginServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet( urlPatterns = {"/NewUser"} )
public class AddUser extends LoginServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/newUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        new Users().createUser(request.getParameterMap());

        String username = request.getParameter("username");
        String password = request.getParameter("password1");
        request.login(username, password);

        checkForLogin(request);

        response.sendRedirect(request.getContextPath() + "/");
    }
}
