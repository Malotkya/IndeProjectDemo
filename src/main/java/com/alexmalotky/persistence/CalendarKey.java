package com.alexmalotky.persistence;

import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CalendarKey implements Serializable {
    private User user;
    private Recipe recipe;
    private Date date;

    public CalendarKey() {
    }

    public CalendarKey(User user, Recipe recipe, Date date) {
        this.user = user;
        this.recipe = recipe;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalendarKey)) return false;
        CalendarKey that = (CalendarKey) o;

        LocalDate myDate = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDate thatDate = LocalDate.ofInstant(that.date.toInstant(), ZoneId.systemDefault());

        return Objects.equals(user, that.user) &&
                Objects.equals(recipe, that.recipe) &&
                myDate.isEqual(thatDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, recipe, date);
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Object> generateMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("user", user);
        map.put("recipe", recipe);
        map.put("date", date);

        return map;
    }
}
