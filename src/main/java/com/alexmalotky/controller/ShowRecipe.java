package com.alexmalotky.controller;

import com.alexmalotky.entity.Favorite;
import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet( urlPatterns = {"/Recipe"} )
public class ShowRecipe extends HttpServlet {

    private GenericDao<Recipe> dao = new GenericDao<>(Recipe.class);
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Recipe r = dao.getById(id);
        User user = (User)request.getSession().getAttribute("user");
        boolean favorite = false;

        if(user != null)
            favorite = user.getFavorites().contains(r);

        if(favorite)
            logger.debug(user.getUserName() + " likes " + r.getName());
        else
            logger.debug("Not a favorite.");

        request.setAttribute("recipe", r);
        request.setAttribute("isFavorite", favorite);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/recipe.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String submitType = request.getParameter("submit");
        int id = Integer.parseInt(request.getParameter("id"));
        Recipe recipe = dao.getById(id);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");


        switch (submitType) {
            case "Save":
                performSave(request, recipe);
                response.sendRedirect(request.getContextPath() + "/Recipe?id=" + id);
                break;
            case "Delete":
                performDelete(recipe);
                response.sendRedirect(request.getContextPath() + "/");
                break;
            case "Like":
                performLike(user, recipe);
                response.sendRedirect(request.getContextPath() + "/Recipe?id=" + id);
                break;
            case "Unlike":
                performUnlike(user, recipe);
                response.sendRedirect(request.getContextPath() + "/Recipe?id=" + id);
                break;
        }
    }

    private void performSave(HttpServletRequest request, Recipe recipe) {

        String newName = request.getParameter("recipeName");
        Boolean makePublic = Boolean.getBoolean(request.getParameter("publicView"));
        String newIngredients = request.getParameter("ingredients");
        String newDirections = request.getParameter("directions");

        recipe.setName(newName);
        recipe.setPublicView(makePublic);
        recipe.setIngredients(newIngredients);
        recipe.setDirections(newDirections);

        dao.saveOrUpdate(recipe);
    }

    private void performDelete(Recipe recipe) {

        dao.delete(recipe);
    }

    private void performLike(User user, Recipe recipe) {

        Favorite f = new Favorite(user, recipe);
        GenericDao<Favorite> favDao = new GenericDao<>(Favorite.class);


        favDao.insert(f);
        user.getFavorites().add(recipe);
    }

    private void performUnlike(User user, Recipe recipe){

        GenericDao<Favorite> favDao = new GenericDao<>(Favorite.class);
        Map<String, Object> map = new HashMap<>();

        map.put("user", user);
        map.put("recipe", recipe);

        List<Favorite> list = favDao.findByPropertyEqual(map);

        for(Favorite f: list)
            favDao.delete(f);

        user.getFavorites().remove(recipe);
    }
}

