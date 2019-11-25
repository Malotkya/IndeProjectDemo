package com.alexmalotky.controller;

import com.alexmalotky.entity.Recipe;
import com.alexmalotky.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet( urlPatterns = {"/Search"} )
public class Search extends HttpServlet {

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
}
