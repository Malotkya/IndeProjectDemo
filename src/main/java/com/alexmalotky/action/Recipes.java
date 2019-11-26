package com.alexmalotky.action;

import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;
import com.alexmalotky.persistence.GenericDao;

import java.util.Map;

public class Recipes {

    private GenericDao<Recipe> dao = new GenericDao<>(Recipe.class);
    private User user;

    public Recipes(User user) {
        this.user = user;
    }

    public Recipe makeNewRecipe() {
        int id = (Integer)dao.insert(new Recipe("Recipe Name", user));
        return dao.getById(id);
    }

    public void save(Recipe recipe, Map<String, String[]> args) {

        String name = null, publicView = null, ingredients = null, directions = null;

        if(args != null) {
            name = args.get("recipeName")[0];
            publicView = args.get("publicView")[0];
            ingredients = args.get("ingredients")[0];
            directions = args.get("directions")[0];
        }

        if (publicView == null)
            recipe.setPublicView(false);
        else
            recipe.setPublicView(publicView.equals("on"));
        if (name == null)
            recipe.setName(name);
        if (ingredients == null)
            recipe.setIngredients(ingredients);
        if (directions == null)
            recipe.setDirections(directions);

        dao.saveOrUpdate(recipe);
    }

    public void delete(Recipe recipe) {
        dao.delete(recipe);
    }
}
