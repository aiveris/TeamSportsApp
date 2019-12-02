package com.montini.teamsports.model;

import org.springframework.stereotype.Component;

@Component
public class PlayEvent {
    private int id;
    private String location;
    private int date;
    private String title;
    private enum type {
        SINGLES_OPEN,
        SINGLES_CLOSE,
        DOUBLES_OPEN,
        DOUBLES_CLOSE
    }
    private String organiser;
    private String users;
    private int freeSlots;

    public PlayEvent() {}

    public PlayEvent(String location, int date, String title, String organiser, String users, int freeSlots) {
        this.location = location;
        this.date = date;
        this.title = title;
        this.organiser = organiser;
        this.users = users;
        this.freeSlots = freeSlots;
    }
    // Getters and Setters

    public int getId() { return id; }
    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getDate() { return date; }
    public void setDate(int date) { this.date = date; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getOrganiser() { return organiser; }
    public void setOrganiser(String organiser) { this.organiser = organiser; }

    public String getUsers() { return users; }
    public void setUsers(String users) { this.users = users; }

    public int getFreeSlots() { return freeSlots; }
    public void setFreeSlots(int freeSlots) { this.freeSlots = freeSlots; }

}


