package com.alexmalotky.controller;


import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.UserDao;
import com.alexmalotky.util.LoginServlet;
import org.apache.catalina.realm.MessageDigestCredentialHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


@WebServlet( urlPatterns = {"/NewUser"} )
public class AddUser extends LoginServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private UserDao dao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/newUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password1");

        User user = new User(firstName, lastName, username, email);

        MessageDigestCredentialHandler credentialHandler = new MessageDigestCredentialHandler();

        try {
            credentialHandler.setAlgorithm("sha-256");
        } catch (NoSuchAlgorithmException e) {
            logger.debug(e);
        }

        credentialHandler.setEncoding("UTF-8");
        String hashedPassword = credentialHandler.mutate(password);

        user.setPassword(hashedPassword);
        dao.insert(user);

        login(username, password, request);
        response.sendRedirect(request.getContextPath() + "/");
    }

    private void login(String username, String password, HttpServletRequest request) throws ServletException {
        request.login(username, password);

        HttpSession session = request.getSession();
        UserDao dao = new UserDao();
        User user = dao.getUserByUserName(request.getRemoteUser());

        session.setAttribute("user", user);
    }
}
