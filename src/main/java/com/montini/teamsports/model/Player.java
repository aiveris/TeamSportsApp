package com.montini.teamsports.model;

import org.springframework.stereotype.Component;

@Component
public class Player {

    private int id;
    private String username, password, email;
    private int rank;
    private Type type;
    // private List<PlayEvent> myEventList;

    // Constructors

    public Player() {}

    // Getters and Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getRank() { return rank; }
    public void setRank(int rank) { this.rank = rank; }

    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }

    // Methods

}