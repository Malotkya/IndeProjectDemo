package com.alexmalotky.util;

import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected final static Logger logger = LogManager.getLogger(LoginServlet.class);

    protected User getLoggedInUser(HttpServletRequest request) throws NotLoggedInException {
        //get updated user from database.
        UserDao dao = new UserDao();
        User user = dao.getUserByUserName(request.getRemoteUser());

        //make sure user exists
        if(user == null)
            throw new NotLoggedInException();

        //add user to session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return user;
    }

    protected void checkForLogin(HttpServletRequest request) {
        try
        {
            getLoggedInUser(request);
        }
        catch( NotLoggedInException e)
        {
            //Do Nothing
        }
    }
}
