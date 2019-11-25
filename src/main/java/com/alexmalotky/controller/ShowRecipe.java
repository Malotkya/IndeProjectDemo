package com.alexmalotky.controller;

import com.alexmalotky.action.Favorites;
import com.alexmalotky.action.Planner;
import com.alexmalotky.entity.Calendar;
import com.alexmalotky.entity.Favorite;
import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.CalendarKey;
import com.alexmalotky.persistence.GenericDao;
import com.alexmalotky.persistence.FavoriteKey;
import com.alexmalotky.util.LoginServlet;
import com.alexmalotky.util.NotLoggedInException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet( urlPatterns = {"/Recipe"} )
public class ShowRecipe extends LoginServlet {

    private GenericDao<Recipe> dao = new GenericDao<>(Recipe.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Recipe r = dao.getById(id);
        request.setAttribute("recipe", r);

        try {
            User user = getLoggedInUser(request);
            if (user.getFavorites().contains(r))
                request.setAttribute("isFavorite", true);
        } catch (NotLoggedInException e) {
            //Do Nothing
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/recipe.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = getLoggedInUser(request);
            String submitType = request.getParameter("submitType");
            int id = Integer.parseInt(request.getParameter("id"));
            Recipe recipe = dao.getById(id);

            switch (submitType) {
                case "Save":
                    performSave(request, recipe);
                    response.sendRedirect(request.getContextPath() + "/Recipe?id=" + id);
                    break;
                case "Delete":
                    performDelete(recipe);
                    response.sendRedirect(request.getContextPath());
                    break;
                case "Unlike":
                    Favorites.unlike(user, recipe);
                    response.sendRedirect(request.getContextPath() + "/Recipe?id=" + id);
                    break;
                case "Like":
                    Favorites.like(user, recipe);
                    response.sendRedirect(request.getContextPath() + "/Recipe?id=" + id);
                    break;
                case "Date":
                    long date = Long.parseLong(request.getParameter("date"));
                    Planner.add(user, recipe, date);
                    response.sendRedirect(request.getContextPath() + "/Recipe?id=" + id);
                    break;
            }
        } catch (NotLoggedInException e) {
            logger.error("Invalid request from: " + request.getRemoteAddr());
        }
    }

    private void performSave(HttpServletRequest request, Recipe recipe) {
        String newName = request.getParameter("recipeName");
        String publicView = request.getParameter("publicView");
        String newIngredients = request.getParameter("ingredients");
        String newDirections = request.getParameter("directions");

        if (publicView == null)
            publicView = "off";

        recipe.setName(newName);
        recipe.setPublicView(publicView.equals("on"));
        recipe.setIngredients(newIngredients);
        recipe.setDirections(newDirections);

        dao.saveOrUpdate(recipe);
    }

    private void performDelete(Recipe recipe) {
        dao.delete(recipe);
    }
}

