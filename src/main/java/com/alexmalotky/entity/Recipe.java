package com.alexmalotky.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

    public void setId(int id) {this.id = id;};
    public int getId() {return id;};

    public void setName(String name) {this.name = name;};
    public String getName() {return name;};

    public void setIngredients(String ingredients){this.ingredients = ingredients;};
    public String getIngredients(){return ingredients;};

    public void setDirections(String directions){this.directions = directions;};
    public String getDirections() {return directions;};

}
