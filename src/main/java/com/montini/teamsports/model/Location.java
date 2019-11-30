package com.montini.teamsports.model;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String address;
    private int maxCourts;
    private String logo;

    // Constructors

    public Location() {}

    public Location(String name, String address, int maxCourts, String logo) {
        this.name = name;
        this.address = address;
        this.maxCourts = maxCourts;
        this.logo = logo;
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

    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }

}
