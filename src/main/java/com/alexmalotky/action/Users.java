package com.alexmalotky.action;

import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.GenericDao;
import com.alexmalotky.util.PasswordManager;

import java.util.Map;

public class Users {

    private GenericDao<User> dao = new GenericDao<>(User.class);

    public Users() {}

    public User createUser(Map<String,String[]> args) {
        String email = args.get("email")[0];
        String firstName = args.get("firstName")[0];
        String lastName = args.get("lastName")[0];
        String username = args.get("username")[0];
        String password = args.get("password1")[0];

        int id = (Integer)dao.insert(new User(firstName, lastName, username, email,
                                    PasswordManager.hash(password)));

        User user = dao.getById(id);
        new Roles(user).add("registered-user");

        return user;
    }

    public void save(User user, Map<String, String[]> args){
        String[] firstName = args.get("firstName");
        String[] lastName = args.get("lastName");
        String[] email = args.get("email");
        String[] password = args.get("password1");

        if(firstName != null)
            user.setFirstName(firstName[0]);
        if(lastName != null)
            user.setLastName(lastName[0]);
        if(email != null)
            user.setEmail(email[0]);
        if(password != null)
            user.setPassword(PasswordManager.hash(password[0]));

        dao.saveOrUpdate(user);
    }

    public void delete(User user){

        //Unlink users from their recipes
        for(Recipe recipe: user.getRecipes()) {
            recipe.setUser(null);
            new Recipes(user).save(recipe, null);
        }

        dao.delete(user);
    }



}
