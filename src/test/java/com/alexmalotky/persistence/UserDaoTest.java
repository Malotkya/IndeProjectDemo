package com.alexmalotky.persistence;

import com.alexmalotky.entity.User;
import com.alexmalotky.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDao();
    }

    @Test
    public void testGetAllUsers() {
        List<User> list = dao.getAllUsers();
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

        assertEquals(null, dao.getUserById(3));
    }
}