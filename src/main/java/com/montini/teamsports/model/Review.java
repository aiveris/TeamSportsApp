package com.montini.teamsports.model;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", unique = true, nullable = false)
    private int id;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Player player;

    @JsonIgnore
    @ManyToOne
    private PlayEvent playEvent;


    // Constructors
    public Review() {
    }

    public Review(int Id, Timestamp timestamp, String description) {
        this.id = Id;
        this.timestamp = timestamp;
        this.description = description;
    }

    // Getters and Setters
    @JsonGetter("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonGetter("timestamp")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonGetter("player")
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public PlayEvent getPlayEvent() {
        return playEvent;
    }

    public void setPlayEvent(PlayEvent playEvent) {
        this.playEvent = playEvent;
    }
}
