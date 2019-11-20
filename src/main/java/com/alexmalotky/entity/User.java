package com.alexmalotky.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
@Table(name = "users")
public class User {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER )
    private Set<Recipe> recipes = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="favorites",
                joinColumns =        {@JoinColumn(name="user_id", nullable = false, updatable = false)},
                inverseJoinColumns = {@JoinColumn(name="recipe_id", nullable = false, updatable = false)})
    private Set<Recipe> favorites = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER )
    private Set<Calendar> calendar = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, String userName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", recipes=" + recipes +
                '}';
    }

    public int getId() {return id;}
    public void setId(int id){this.id = id;}

    public String getUserName() {return userName;}
    public void setUserName(String userName){ this.userName = userName;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName){ this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName){ this.lastName = lastName;}

    public String getEmail(){return email;}
    public void setEmail(String email) { this.email = email;}

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipe.setUser(this);
        recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
    }

    public Set<Recipe> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Recipe> favorites) {
        this.favorites = favorites;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Calendar> getCalendar() {
        return calendar;
    }

    public void setCalendar(Set<Calendar> calendar) {
        this.calendar = calendar;
    }
}
