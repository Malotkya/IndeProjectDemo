package com.alexmalotky.controller;

import com.alexmalotky.entity.Favorite;
import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.GenericDao;
import com.alexmalotky.persistence.UserDao;
import com.alexmalotky.persistence.FavoriteKey;
import com.alexmalotky.util.LoginServlet;
import com.alexmalotky.util.NotLoggedInException;
import com.alexmalotky.util.PasswordManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( urlPatterns = {"/Account"} )
public class UserAccount extends LoginServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            getLoggedInUser(request);
        }
        catch (NotLoggedInException e)
        {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }

        String show = request.getParameter("show");
        if(show == null)
            show = "favs";

        request.setAttribute( show+"Btn", "active");
        request.setAttribute(show+"Pane", "show active");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/account.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "";

        try
        {
            User user = getLoggedInUser(request);
            String submitType = request.getParameter("submit");

            switch (submitType) {
                case "Delete":
                    deleteRecipe(request);
                    redirect = "owned";
                    break;
                case "Unlike":
                    unLikeRecipe(user, request);
                    redirect = "favs";
                    break;
                case "Update":
                    updateUser(user, request);
                    redirect = "settings";
                    break;
                case "Change Password":
                    changePassword(user, request);
                    redirect = "settings";
                    break;
            }
        }
        catch (NotLoggedInException e)
        {
            logger.error("Invalid request from: " + request.getRemoteAddr());
        }

        response.sendRedirect(request.getContextPath() + "/Account?show=" + redirect);
    }

    private void deleteRecipe(HttpServletRequest request) {
        GenericDao<Recipe> recipeDao = new GenericDao<>(Recipe.class);
        int id = Integer.parseInt(request.getParameter("id"));
        Recipe r = recipeDao.getById(id);
        recipeDao.delete(r);
    }

    private void unLikeRecipe(User user, HttpServletRequest request) {
        GenericDao<Favorite> favDao = new GenericDao<>(Favorite.class);
        GenericDao<Recipe> recipeDao = new GenericDao<>(Recipe.class);

        int id = Integer.parseInt(request.getParameter("id"));
        Recipe recipe = recipeDao.getById(id);

        FavoriteKey key = new FavoriteKey(user, recipe);

        List<Favorite> list = favDao.findByPropertyEqual(key.generateMap());

        for(Favorite f: list)
            favDao.delete(f);
    }

    private void updateUser(User user, HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        UserDao userDao = new UserDao();
        userDao.update(user);
    }

    private void changePassword(User user, HttpServletRequest request) {
        String password = request.getParameter("newPassword1");

        user.setPassword(PasswordManager.hash(password));

        UserDao userDao = new UserDao();
        userDao.update(user);
    }
}