package com.montini.teamsports.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "player")
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @NotNull
    private String username, password, email;
    @NotNull
    private Integer rank;
    private Integer userType; // 0 - regular user, 1 - admin
    // private List<PlayEvent> myEventList;

    // Constructors

    public Player() {}

// Getters and Setters

    @JsonGetter("id")
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @JsonGetter("username")
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @JsonGetter("password")
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @JsonGetter("email")
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @JsonGetter("rank")
    public Integer getRank() { return rank; }
    public void setRank(Integer rank) { this.rank = rank; }

    @JsonGetter("user_type")
    public Integer getUserType() { return userType; }
    public void setUserType(Integer userType) { this.userType = userType; }

    // Methods

}