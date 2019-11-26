package com.alexmalotky.controller;

import com.alexmalotky.action.Favorites;
import com.alexmalotky.action.Planner;
import com.alexmalotky.action.Recipes;
import com.alexmalotky.action.Users;
import com.alexmalotky.entity.*;
import com.alexmalotky.persistence.GenericDao;
import com.alexmalotky.util.LoginServlet;
import com.alexmalotky.util.NotLoggedInException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = {"/Account"} )
public class UserAccount extends LoginServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            getLoggedInUser(request);

            String show = request.getParameter("show");
            if(show == null)
                show = "favs";

            request.setAttribute( show+"Btn", "active");
            request.setAttribute(show+"Pane", "show active");
        }
        catch (NotLoggedInException e)
        {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/account.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "";
        String show = request.getParameter("show");

        try
        {
            User user = getLoggedInUser(request);
            String submitType = request.getParameter("submitType");
            long date;

            switch (submitType) {
                case "Delete":
                    new Recipes(user).delete(getRecipe(request));
                    redirect = "owned";
                    break;
                case "Unlike":
                    new Favorites(user).unlike(getRecipe(request));
                    redirect = "favs";
                    break;
                case "Update":
                case "Change Password":
                    new Users().save(user, request.getParameterMap());
                    redirect = "settings";
                    break;
                case "Remove":
                    date = Long.parseLong(request.getParameter("date"));
                    new Planner(user).delete(getRecipe(request), date);
                    redirect = "planner";
                case "Date":
                    date = Long.parseLong(request.getParameter("date"));
                    new Planner(user).add(getRecipe(request), date);
                    break;
            }
        }
        catch (NotLoggedInException e)
        {
            logger.error("Invalid request from: " + request.getRemoteAddr());
        }

        if(redirect.equals("") && show != null)
            redirect = show;

        response.sendRedirect(request.getContextPath() + "/Account?show=" + redirect);
    }

    private Recipe getRecipe(HttpServletRequest request) {
        GenericDao<Recipe> dao = new GenericDao<>(Recipe.class);
        int id = Integer.parseInt(request.getParameter("id"));
        return dao.getById(id);
    }
}