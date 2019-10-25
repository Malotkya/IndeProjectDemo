package com.alexmalotky.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Recipe")
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "directions")
    private String directions;

    @Column(name = "public")
    private Boolean publicView;

    @ManyToOne
    private User user;

    public Recipe() {

    }

    public Recipe(String name, String ingredients, String directions) {
        this.name = name;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public Recipe(String name, User user){
        this.name = name;
        this.user = user;
        this.ingredients = "[]";
        this.directions = "[]";
        this.publicView = false;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", directions='" + directions + '\'' +
                ", user=" + user.getFirstName() + " " + user.getLastName() +
                '}';
    }

    public void setId(int id) {this.id = id;}
    public int getId() {return id;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setIngredients(String ingredients){this.ingredients = ingredients;}
    public String getIngredients(){return ingredients;}

    public void setDirections(String directions){this.directions = directions;}
    public String getDirections() {return directions;}

    public void setUser(User user){this.user = user;}
    public User getUser(){return user;}

    public Boolean getPublicView() {
        return publicView;
    }

    public void setPublicView(Boolean publicView) {
        this.publicView = publicView;
    }

    public String getChecked() {

        if(publicView)
            return "checked";
        else
            return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
