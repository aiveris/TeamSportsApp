package com.montini.teamsports.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String address;
    private int maxCourts;
    private int freeCourts;

    // Constructors

    public Location() {}

    public Location(String name, String address, int maxCourts, int freeCourts) {
        this.name = name;
        this.address = address;
        this.maxCourts = maxCourts;
        this.freeCourts = freeCourts;
    }

    // Getters and Setters

    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getMaxCourts() { return maxCourts; }
    public void setMaxCourts(int maxCourts) { this.maxCourts = maxCourts; }

    public int getFreeCourts() {
        return freeCourts;
    }

    public void setFreeCourts(int freeCourts) {
        this.freeCourts = freeCourts;
    }
}