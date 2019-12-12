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
//    private Location location_id;
    private Integer location_id;
    private String eventDate;
    private String eventTime;
    private String title;
    private Integer gameType;
    private Integer freeSlots;
    private Integer player_id;
    private Integer review_id;


    // Constructors

    public PlayEvent() {
    }

    public PlayEvent(Integer location, String eventDate, String eventTime, String title, Integer gameType, Integer freeSlots, Integer player, Integer review) {
        this.location_id = location;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.title = title;
        this.gameType = gameType;
        this.freeSlots = freeSlots;
        this.player_id = player;
        this.review_id = review;
    }
    // Getters and Setters

    @JsonGetter("id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonGetter("location")
    public Integer getLocation() {
        return location_id;
    }

    public void setLocation(Integer location) {
        this.location_id = location;
    }

    @JsonGetter("eventTime")
    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    @JsonGetter("eventDate")
    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonGetter("gameType")
    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }

    @JsonGetter("freeSlots")
    public Integer getFreeSlots() {
        return freeSlots;
    }

    public void setFreeSlots(Integer freeSlots) {
        this.freeSlots = freeSlots;
    }


    @JsonGetter("player")
    public Integer getPlayer() {
        return player_id;
    }

    public void setPlayer(Integer player) {
        this.player_id = player;
    }

    @JsonGetter("review")
    public Integer getReview() {
        return review_id;
    }

    public void setReview(Integer review) {
        this.review_id = review;
    }

}






