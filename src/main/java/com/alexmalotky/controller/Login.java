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


@WebServlet( urlPatterns = {"/Login"} )
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDao dao = new UserDao();

        String user_name = request.getParameter("j_username");
        String password = request.getParameter("j_password");

        User user = dao.getUserByUserName(user_name);
        if( user == null ) {
            session.invalidate();
        }
        else {
            if( checkpw(password, user.getPassword()) )
                session.setAttribute("user", user);
            else
                session.invalidate();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
