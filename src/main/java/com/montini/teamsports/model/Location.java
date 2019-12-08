package com.montini.teamsports.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "location")
public class Location  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @NotNull
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

    @JsonGetter("id")
    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonGetter("name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @JsonGetter("address")
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @JsonGetter("maxCourts")
    public int getMaxCourts() { return maxCourts; }
    public void setMaxCourts(int maxCourts) { this.maxCourts = maxCourts; }

    @JsonGetter("freeCourts")
    public int getFreeCourts() {
        return freeCourts;
    }
    public void setFreeCourts(int freeCourts) {
        this.freeCourts = freeCourts;
    }

}