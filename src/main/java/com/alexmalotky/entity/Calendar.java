package com.alexmalotky.entity;

import com.alexmalotky.persistence.CalendarKey;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity(name = "Calendar")
@Table(name = "calendar")
@IdClass(CalendarKey.class)
public class Calendar {

    @Id
    @ManyToOne
    private User user;

    @Id
    @ManyToOne
    private Recipe recipe;

    @Id
    @Column(name="record")
    private long date;

    public Calendar() {}

    public Calendar(User user, Recipe recipe, long date) {
        this.user = user;
        this.recipe = recipe;
        this.date = date;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public LocalDate getLocalDate() {
        return LocalDate.ofInstant(new Date(date).toInstant(), ZoneId.systemDefault());
    }
}
