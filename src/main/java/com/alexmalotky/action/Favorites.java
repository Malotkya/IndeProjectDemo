package com.alexmalotky.action;

import com.alexmalotky.entity.*;
import com.alexmalotky.persistence.GenericDao;

public class Favorites {

    private GenericDao<Favorite> dao = new GenericDao<>(Favorite.class);
    private User user;

    public Favorites (User user) {
        this.user = user;
    }

    public void like(Recipe recipe) {

        dao.insert(new Favorite(user, recipe));
    }

    public void unlike(Recipe recipe) {
        GenericDao<Favorite> dao = new GenericDao<>(Favorite.class);
        dao.delete(new Favorite(user, recipe));
    }

}
