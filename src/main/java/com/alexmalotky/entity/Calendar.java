package com.alexmalotky.entity;

import com.alexmalotky.persistence.CalendarKey;

import javax.persistence.*;
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
    private Date date;

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
}
