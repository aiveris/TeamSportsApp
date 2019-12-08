package com.montini.teamsports.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "description")
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
