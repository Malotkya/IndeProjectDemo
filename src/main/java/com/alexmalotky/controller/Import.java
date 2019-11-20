package com.alexmalotky.controller;

import com.alexmalotky.entity.Favorite;
import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.GenericDao;
import com.alexmalotky.util.LoginServlet;
import com.spoonacular.client.RecipeScraper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = {"/Import"} )
public class Import extends LoginServlet {

    private GenericDao<Recipe> dao = new GenericDao<>(Recipe.class);
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao<Favorite> favDao = new GenericDao<>(Favorite.class);
        String redirect = request.getContextPath();

        try {
            User u = getLoggedInUser(request);
            String url = request.getParameter("url");

            RecipeScraper scraper = new RecipeScraper();
            Recipe r = scraper.get(url);

            r.setUser(u);
            dao.insert(r);

            Favorite f = new Favorite(u, r);
            favDao.insert(f);

            redirect += "/Recipe?id=" + r.getId();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            redirect += "/error.jsp";
        }

        response.sendRedirect(redirect);
    }
}