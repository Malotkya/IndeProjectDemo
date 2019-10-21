package com.alexmalotky.controller;


import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet( urlPatterns = {"/Login"} )
public class Login extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDao dao = new UserDao();
        User user = dao.getUserByUserName(request.getRemoteUser());

        session.setAttribute("user", user);

        response.sendRedirect(request.getHeader("referer"));
    }
}
