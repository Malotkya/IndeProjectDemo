package com.alexmalotky.controller;

import com.alexmalotky.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

@WebServlet( urlPatterns = {"/Recipe"} )
public class Recipe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao<Recipe> recipeDao = new GenericDao<Recipe>(Recipe.class);

        int id = (Integer)request.getAttribute("id");

        request.setAttribute("recipe", recipeDao.getById(id));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request, response);
    }
}
