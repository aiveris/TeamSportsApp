package com.montini.teamsports.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "playevent")
public class PlayEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "playevent_id", unique = true, nullable = false)
    private Integer id;

    @NotNull
    private Date eventDate;
    private String title;
    private GameType gameType;
    private Integer freeSlots;

    private Location location;




    // Constructors

    public PlayEvent() {}

    public PlayEvent(Location location, Date eventDate, String title, GameType gameType, Integer freeSlots) {
        this.location = location;
        this.eventDate = eventDate;
        this.title = title;
        this.gameType = gameType;
        this.freeSlots = freeSlots;
    }
    // Getters and Setters

    @JsonGetter("id")
    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }
    @JsonGetter("location")
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
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
    @JsonGetter("freeSlots")
    public Integer getFreeSlots() { return freeSlots; }
    public void setFreeSlots(Integer freeSlots) { this.freeSlots = freeSlots; }

}






