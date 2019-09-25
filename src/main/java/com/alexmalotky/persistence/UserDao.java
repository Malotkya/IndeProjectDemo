package com.alexmalotky.persistence;

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
}
