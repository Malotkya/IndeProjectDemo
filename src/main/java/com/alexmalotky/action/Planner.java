package com.alexmalotky.action;

import com.alexmalotky.entity.Calendar;
import com.alexmalotky.entity.Favorite;
import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.GenericDao;

public class Planner {
    public static void add(User user, Recipe recipe, long date) {
        GenericDao<Calendar> dao = new GenericDao<>(Calendar.class);
        dao.insert(new Calendar(user, recipe, date));
    }

    public static void delete(User user, Recipe recipe, long date) {
        GenericDao<Calendar> dao = new GenericDao<>(Calendar.class);
        dao.delete(new Calendar(user, recipe, date));
    }
}
