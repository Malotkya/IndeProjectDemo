package com.alexmalotky.controller;

import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.Units;
import com.alexmalotky.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = {"/Recipe"} )
public class ShowRecipe extends HttpServlet {

    private GenericDao<Recipe> dao = new GenericDao<>(Recipe.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO add unit to global session later
        Units units = new Units();
        request.setAttribute("units", units);

        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("recipe", dao.getById(id));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/recipe.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String submitType = request.getParameter("submit");
        int id = Integer.parseInt(request.getParameter("id"));

        switch (submitType) {
            case "Save":
                performSave(request, id);
                response.sendRedirect(request.getContextPath() + "/Recipe?id=" + id);
                break;
            case "Delete":
                performDelete(id);
                response.sendRedirect(request.getContextPath() + "/");
                break;
            case "Like":
                performLike(id);
                response.sendRedirect(request.getContextPath() + "/Recipe?id=" + id);
                break;
            case "Unlike":
                performUnlike(id);
                response.sendRedirect(request.getContextPath() + "/Recipe?id=" + id);
                break;
        }
    }

    private void performSave(HttpServletRequest request, int id) {
        Recipe recipe = dao.getById(id);
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

    private void performDelete(int id) {
        Recipe recipe = dao.getById(id);
        dao.delete(recipe);
    }

    private void performLike(int id) {
        //TODO add recipe and user to liked table
    }

    private void performUnlike(int id){
        //TODO remove recipe and user from liked table
    }
}

