package com.alexmalotky.persistence;

import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;
import com.alexmalotky.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RecipeDaoTest {

    private GenericDao<Recipe> dao = new GenericDao<>(Recipe.class);
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao<>(Recipe.class);
    }

    @Test
    void testGetAll(){
        List<Recipe> list = dao.getAll();

        assertEquals(3, list.size());
    }

    @Test
    void testGetByID(){
        Recipe recipe = dao.getById(1);
        assertEquals("Sliced Bread", recipe.getName());
    }

    @Test
    void testInsertSuccess(){
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = userDao.getById(1);

        Recipe newRecipe = new Recipe("testInsert", "", "");
        newRecipe.setUser(user);

        int id = (int)dao.insert(newRecipe);
        Recipe testRecipe = dao.getById(id);

        assertEquals(newRecipe.toString(), testRecipe.toString());
    }

    @Test
    void testInsertFail(){
        User user = new User("Not Real", "Please Be Not Real", "Tots_Fake", "", "");
        Recipe newRecipe = new Recipe("testInsert", "", "");
        newRecipe.setUser(user);

        assertThrows(Exception.class , () -> dao.insert(newRecipe));
    }

    @Test
    void testDelete(){
        Recipe recipe = dao.getById(3);
        dao.delete(recipe);

        assertEquals(2, dao.getAll().size());
    }

    @Test
    void testUpdate(){
        Recipe recipe = dao.getById(3);
        recipe.setDirections("Do the thing");

        dao.saveOrUpdate(recipe);
    }

    @Test
    void testFindByProperty(){
        List<Recipe> list = dao.findByPropertyEqual("name", "Sliced Bread");

        assertEquals(1, list.size());
    }

    @Test
    void testFindByMultipleProerties(){
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = userDao.getById(1);

        Map<String, Object> paramater = new HashMap<>();
        paramater.put("user", user);
        paramater.put("name", "Sliced Bread");

        List<Recipe> list = dao.findByPropertyEqual(paramater);
        assertEquals(1, list.size());
    }
}
