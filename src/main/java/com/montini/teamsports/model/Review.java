package com.montini.teamsports.model;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Review {
    private int id;
    private Timestamp timestamp;
    private String description;

    // Constructors
    public Review() {
    }

    public Review(int Id, Timestamp timestamp, String description) {
        this.id = Id;
        this.timestamp = timestamp;
        this.description = description;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
