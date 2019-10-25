package com.alexmalotky.controller;

import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.UserDao;
import com.alexmalotky.util.LoginServlet;
import com.alexmalotky.util.NotLoggedInException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( urlPatterns = {"/Account"} )
public class UserAccount extends LoginServlet {

    private UserDao dao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try
        {
            getLoggedInUser(request);
        }
        catch (NotLoggedInException e)
        {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/account.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String submitType = request.getParameter("submit");

        //TODO: add stuff here
    }
}