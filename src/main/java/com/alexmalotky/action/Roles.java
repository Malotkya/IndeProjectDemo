package com.alexmalotky.action;

import com.alexmalotky.entity.Role;
import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.GenericDao;

public class Roles {

    private GenericDao<Role> dao = new GenericDao<>(Role.class);
    private User user;

    public Roles(User user) {
        this.user = user;
    }

    public void add(String role) {
        dao.insert(new Role(user.getUserName(), role));
    }

    public void delete(String role) {
        dao.delete(new Role(user.getUserName(), role));
    }
}
