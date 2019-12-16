package com.alexmalotky.util;

import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class LoginServlet extends HttpServlet {

    protected final static Logger logger = LogManager.getLogger(LoginServlet.class);

    protected User getLoggedInUser(HttpServletRequest request) throws NotLoggedInException {
        //get updated user from database.
        GenericDao<User> dao = new GenericDao<>(User.class);
        List users = dao.findByPropertyEqual("userName", request.getRemoteUser());

        //make sure user exists
        if(users.isEmpty())
            throw new NotLoggedInException();

        User user = (User)users.get(0);

        //add user to session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return user;
    }

    protected User checkForLogin(HttpServletRequest request) {
        try
        {
            return getLoggedInUser(request);
        }
        catch( NotLoggedInException e)
        {
            return null;
        }

    }
}
