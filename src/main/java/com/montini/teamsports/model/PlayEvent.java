package com.montini.teamsports.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
@Entity
@Table(name = "playevent")
public class PlayEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @NotNull
    private int location_id;
    private Date eventDate;
    private String title;
    private GameType gameType;
    private int review_id;
    private String organiser;
    private String users;
    private int freeSlots;

    // Constructors

    public PlayEvent() {}

    public PlayEvent(int location_id, Date eventDate, String title, GameType gameType, int review_id, String organiser, String users, int freeSlots) {
        this.location_id = location_id;
        this.eventDate = eventDate;
        this.title = title;
        this.gameType = gameType;
        this.review_id = review_id;
        this.organiser = organiser;
        this.users = users;
        this.freeSlots = freeSlots;
    }
    // Getters and Setters

    @JsonGetter("id")
    public int getId() { return id; }
    public void setId(int id) {
        this.id = id;
    }
    @JsonGetter("location_id")
    public int getLocation_id() {
        return location_id;
    }
    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }
    @JsonGetter("eventDate")
    public Date getEventDate() {
        return eventDate;
    }
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
    @JsonGetter("title")
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    @JsonGetter("gameType")
    public GameType getGameType() {
        return gameType;
    }
    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
    @JsonGetter("review_id")
    public int getReview_id() { return review_id; }
    public void setReview_id(int review_id) { this.review_id = review_id; }
    @JsonGetter("organiser")
    public String getOrganiser() { return organiser; }
    public void setOrganiser(String organiser) { this.organiser = organiser; }
    @JsonGetter("users")
    public String getUsers() { return users; }
    public void setUsers(String users) { this.users = users; }
    @JsonGetter("freeSlots")
    public int getFreeSlots() { return freeSlots; }
    public void setFreeSlots(int freeSlots) { this.freeSlots = freeSlots; }

}






