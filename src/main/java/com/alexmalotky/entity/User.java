package com.alexmalotky.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.ejb.Local;
import javax.persistence.*;

@Entity(name = "User")
@Table(name = "users")
public class User {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    public int getId() {return id;};
    public void setId(int id){this.id = id;};

    public String getUserName() {return userName;};
    public void setUserName(String userName){ this.userName = userName;};

    public String getFirstName() {return firstName;};
    public void setFirstName(String firstName){ this.firstName = firstName;};

    public String getLastName() {return lastName;};
    public void setLastName(String lastName){ this.lastName = lastName;};
}
