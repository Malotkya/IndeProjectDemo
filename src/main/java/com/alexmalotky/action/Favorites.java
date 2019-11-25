package com.alexmalotky.action;

import com.alexmalotky.entity.*;
import com.alexmalotky.persistence.GenericDao;

public class Favorites {

    public static void like(User user, Recipe recipe) {
        GenericDao<Favorite> dao = new GenericDao<>(Favorite.class);
        dao.insert(new Favorite(user, recipe));
    }

    public static void unlike(User user, Recipe recipe) {
        GenericDao<Favorite> dao = new GenericDao<>(Favorite.class);
        dao.delete(new Favorite(user, recipe));
    }

}
