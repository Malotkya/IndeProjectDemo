package com.alexmalotky.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet( urlPatterns = {"/Logout"} )
public class Logout extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        killSession(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        killSession(request, response);
    }

    private void killSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.logout();

        HttpSession session = request.getSession();
        session.invalidate();

        response.sendRedirect(request.getContextPath() + "/");
    }
}
