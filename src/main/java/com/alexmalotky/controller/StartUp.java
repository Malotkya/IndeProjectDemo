package com.alexmalotky.controller;

import com.alexmalotky.util.Units;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet( urlPatterns = {"/startup"}, loadOnStartup = 1)
public class StartUp extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void init() {
        ServletContext context = getServletContext();

        Units units = new Units();
        context.setAttribute("units", units);
    }
}
