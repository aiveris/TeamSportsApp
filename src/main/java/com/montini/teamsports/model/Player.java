package com.montini.teamsports.model;

import java.util.List;

// @Entity
public class Player {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username, password, email;
    private int rank;
    private enum type {
        ADMIN,
        USER
    }
    private List<PlayEvent> myEventList;

    // Constructors

    public Player() {}

    // Getters and Setters

    // Methods

}