package com.alexmalotky.action;

import com.alexmalotky.entity.Calendar;
import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.GenericDao;

public class Planner {

    private GenericDao<Calendar> dao = new GenericDao<>(Calendar.class);
    private User user;

    public Planner(User user) {
        this.user = user;
    }

    public void add(Recipe recipe, long date) {
        dao.insert(new Calendar(user, recipe, date));
    }

    public void delete(Recipe recipe, long date) {
        dao.delete(new Calendar(user, recipe, date));
    }
}
