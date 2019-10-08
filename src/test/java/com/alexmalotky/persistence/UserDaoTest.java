package com.alexmalotky.persistence;

import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;
import com.alexmalotky.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private UserDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDao();
    }

    @Test
    void testGetAllUsers() {
        List<User> list = dao.getAllUsers();
        System.out.println(list);
        assertEquals(3, list.size());
    }

    @Test
    void testGetUserById() {
        User user = dao.getUserById(2);
        assertEquals("Malotky", user.getLastName());
    }

    @Test
    void testInsert() {
        String firstName = "Leroy";
        String lastName = "Jenkins";

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName("Blah Blah Blah");

        int id = dao.insert(user);
        user = dao.getUserById(id);
        assertEquals(lastName, user.getLastName() );
    }

    @Test
    void testUpdate() {
        User user = dao.getUserById(3);
        user.setEmail("CalzoneZone@gmail.com");
        dao.update(user);
    }

    @Test
    void testDelete() {
        User user = dao.getUserById(3);
        dao.delete(user);

        assertNull(dao.getUserById(3));
    }

    @Test
    void testInsertNewRecipe() {
        User newUser = new User("Alex", "Malotky", "ajmalotky", "");

        Recipe newRecipe = new Recipe("TestRecipe", "", "");
        newUser.addRecipe(newRecipe);

        int id = dao.insert(newUser);
        User testUser = dao.getUserById(id);

        assertEquals(newUser.toString(), testUser.toString());
    }

    @Test
    void testRemoveOldRecipe() {
        User user = dao.getUserById(2);
        Recipe recipe = user.getRecipes().iterator().next();

        user.removeRecipe(recipe);
        dao.update(user);
    }
}