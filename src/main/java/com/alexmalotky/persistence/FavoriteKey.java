package com.alexmalotky.persistence;

import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FavoriteKey implements Serializable {
    private User user;
    private Recipe recipe;

    public FavoriteKey() {
    }

    public FavoriteKey(User user, Recipe recipe) {
        this.user = user;
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavoriteKey)) return false;
        FavoriteKey that = (FavoriteKey) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, recipe);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Map<String, Object> generateMap() {
        Map map = new HashMap();

        map.put("user", user);
        map.put("recipe", recipe);

        return map;
    }
}
