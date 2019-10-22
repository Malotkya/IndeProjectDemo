package com.alexmalotky.persistence;

import com.alexmalotky.entity.*;
import com.alexmalotky.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FavoritesDaoTest {

    private GenericDao<Favorite> dao = new GenericDao<>(Favorite.class);
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao<>(Favorite.class);

    }

    @Test
    void addNewTest() {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        GenericDao<Recipe> recipeDao = new GenericDao<>(Recipe.class);

        Favorite f = new Favorite(userDao.getById(3), recipeDao.getById(1));
        dao.insert(f);

        List<Favorite> list = dao.getAll();
        assertEquals(6, list.size());
    }

    @Test
    void getAll() {
        List<Favorite> list = dao.getAll();
        assertEquals(5, list.size());
    }

    @Test
    void deleteTest() {
        Favorite f = dao.getById(2);
        dao.delete(f);

        List<Favorite> list = dao.getAll();
        assertEquals(4, list.size());
    }

    @Test
    void getByRecipe() {
        GenericDao<Recipe> recipeDao = new GenericDao<>(Recipe.class);
        Recipe r = recipeDao.getById(3);

        List<Favorite> list = dao.findByPropertyEqual("recipe", r);
        assertEquals(2, list.size());
    }

    @Test
    void getByUser() {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User u = userDao.getById(2);

        List<Favorite> list = dao.findByPropertyEqual("user", u);
        assertEquals(3, list.size());
    }
}
