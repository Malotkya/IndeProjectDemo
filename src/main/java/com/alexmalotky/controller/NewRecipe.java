package com.alexmalotky.controller;

import com.alexmalotky.entity.Favorite;
import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.GenericDao;
import com.alexmalotky.util.LoginServlet;
import com.alexmalotky.util.NotLoggedInException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet( urlPatterns = {"/NewRecipe"} )
public class NewRecipe extends LoginServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao<Recipe> recipeDao = new GenericDao<>(Recipe.class);
        GenericDao<Favorite> favDao = new GenericDao<>(Favorite.class);
        String redirect = request.getContextPath();

        try
        {
            User user = getLoggedInUser(request);
            Recipe newRecipe = new Recipe("Recipe Name", user);
            Favorite newFav = new Favorite(user, newRecipe);

            recipeDao.insert(newRecipe);
            favDao.insert(newFav);

            redirect += "/Recipe?id=" + newRecipe.getId();
        }
        catch (NotLoggedInException e)
        {
            logger.error("Trying to create recipe when not logged in!");
            redirect += "/";
        }

        response.sendRedirect(redirect);
    }
}
