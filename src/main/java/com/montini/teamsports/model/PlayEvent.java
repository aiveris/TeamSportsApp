package com.montini.teamsports.model;

import org.springframework.stereotype.Component;

import java.sql.Time;

@Component
public class PlayEvent {
    private int id;
    private int location_id;
    private Time eventDate;
    private String title;
    private GameType gameType;
    private String organiser;
    private String users;
    private int freeSlots;

    public PlayEvent() {}

    public PlayEvent(int location_id, Time eventDate, String title, GameType gameType, String organiser, String users, int freeSlots) {
        this.location_id = location_id;
        this.eventDate = eventDate;
        this.title = title;
        this.gameType = gameType;
        this.organiser = organiser;
        this.users = users;
        this.freeSlots = freeSlots;
    }
    // Getters and Setters

    public int getId() { return id; }
    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getOrganiser() { return organiser; }
    public void setOrganiser(String organiser) { this.organiser = organiser; }

    public String getUsers() { return users; }
    public void setUsers(String users) { this.users = users; }

    public int getFreeSlots() { return freeSlots; }
    public void setFreeSlots(int freeSlots) { this.freeSlots = freeSlots; }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public Time getEventDate() {
        return eventDate;
    }

    public void setEventDate(Time eventDate) {
        this.eventDate = eventDate;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}


