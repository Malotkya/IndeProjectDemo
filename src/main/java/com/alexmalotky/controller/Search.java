package com.alexmalotky.controller;

import com.alexmalotky.action.Planner;
import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.GenericDao;
import com.alexmalotky.util.LoginServlet;
import com.alexmalotky.util.NotLoggedInException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet( urlPatterns = {"/Search"} )
public class Search extends LoginServlet {

    GenericDao<Recipe> dao = new GenericDao<>(Recipe.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("q");

        if(query != null) {
            String[] tokens = query.split("\\s");
            Map<String, String> params = new HashMap<>();

            for(String token : tokens) {
                if( !token.equals("") )
                    params.put("name", "%" + token + "%");
            }

            List<Recipe> results = dao.findByPropertyLike(params);

            request.setAttribute("results", results);
            request.setAttribute("query", query);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = getLoggedInUser(request);
            String submitType = request.getParameter("submitType");

            switch (submitType) {
                case "Date":
                    long date = Long.parseLong(request.getParameter("date"));
                    new Planner(user).add(getRecipe(request), date);
                    break;
            }
        } catch (NotLoggedInException e) {
            logger.error("Invalid request from: " + request.getRemoteAddr());
        }

        response.sendRedirect(request.getHeader("referer"));
    }

    private Recipe getRecipe(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        return new GenericDao<Recipe>(Recipe.class).getById(id);
    }
}
