package com.alexmalotky.controller;


import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mindrot.jbcrypt.BCrypt.*;


@WebServlet( urlPatterns = {"/NewUser"} )
public class AddUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/newUser.jsp");
        dispatcher.forward(request, response);
    }
}
