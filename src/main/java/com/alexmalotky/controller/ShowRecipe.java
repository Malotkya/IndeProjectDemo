package com.alexmalotky.controller;

import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.Units;
import com.alexmalotky.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = {"/Recipe", "/EditRecipe", "/DeleteRecipe", "/LikeRecipe"} )
public class ShowRecipe extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao<Recipe> recipeDao = new GenericDao<>(Recipe.class);
        Units units = new Units();

        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("recipe", recipeDao.getById(id));
        request.setAttribute("units", units); //TODO add unit to global session later

        RequestDispatcher dispatcher = request.getRequestDispatcher("/recipe.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Only Edit or Delete Here
    }
}

