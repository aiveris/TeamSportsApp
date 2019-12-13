package com.montini.teamsports.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "playevent")
public class PlayEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playevent_id", unique = true, nullable = false)
    private Integer id;

    @NotNull
//    private Location location_id;
    private Location location;
    private Date eventDate;
    private Time eventTime;
    private String title;
    private Integer gameType;
    private Integer freeSlots;
    private Integer review_id;


    @JsonIgnore
    private Set<Player> players = new HashSet<Player>(0);

    @JsonIgnore
    private Set<Review> reviews = new HashSet<Review>(0);

    // Constructors

    public PlayEvent() {
    }

    public PlayEvent(Location location, Date eventDate, Time eventTime, String title, Integer gameType, Integer freeSlots, Integer review) {
        this.location = location;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.title = title;
        this.gameType = gameType;
        this.freeSlots = freeSlots;
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
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonGetter("eventTime")
    public Time getEventTime() {
        return eventTime;
    }

    public void setEventTime(Time eventTime) {
        this.eventTime = eventTime;
    }

    @JsonGetter("eventDate")
    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
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


    @JsonGetter("review")
    public Integer getReview() {
        return review_id;
    }

    public void setReview(Integer review) {
        this.review_id = review;
    }

    @JsonGetter("players")
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @JsonGetter("reviews")
    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}






