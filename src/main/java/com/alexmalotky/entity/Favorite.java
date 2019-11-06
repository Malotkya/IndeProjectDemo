package com.alexmalotky.entity;

import com.alexmalotky.persistence.FavoriteKey;

import javax.persistence.*;

@Entity(name = "Favorite")
@Table(name = "favorites")
@IdClass(FavoriteKey.class)
public class Favorite {

    @Id
    @ManyToOne
    private User user;

    @Id
    @ManyToOne
    private Recipe recipe;

    public Favorite() {
    }

    public Favorite(User user, Recipe recipe)
    {
        this.user = user;
        this.recipe = recipe;
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
}
