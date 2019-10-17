package com.alexmalotky.persistence;

import com.alexmalotky.entity.Favorite;
import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;
import org.apache.logging.log4j.*;
import org.hibernate.*;

import javax.persistence.criteria.*;
import java.util.*;

public class UserDao{

    private final Logger log = LogManager.getLogger(this.getClass());
    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public User getUserByUserName(String user_name) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.equal(root.get("userName"),user_name));
        List<User> output = session.createQuery(query).getResultList();
        session.close();

        if(output.size() < 1)
            return null;

        return output.get(0);
    }

    public int insert(User user){
        int id;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    public void update(User user){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user){
        deleteFavorites(user);
        unLinkRecipes(user);
        deleteUser(user);
    }

    private void deleteFavorites(User user){
        GenericDao<Favorite> dao = new GenericDao<>(Favorite.class);
        List<Favorite> list = dao.findByPropertyEqual("user", user);
        for(Favorite f: list)
            dao.delete(f);
    }

    private void unLinkRecipes(User user) {
        Set<Recipe> list = user.getRecipes();
        GenericDao<Recipe> dao = new GenericDao<>(Recipe.class);

        for(Recipe r: list) {
            r.setUser(null);
            dao.saveOrUpdate(r);
        }

    }

    private void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        user = getUserById(user.getId());
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
