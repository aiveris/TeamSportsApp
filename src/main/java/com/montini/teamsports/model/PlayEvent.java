package com.montini.teamsports.model;

import java.sql.Timestamp;
import java.util.List;

public class PlayEvent {
    private String title;
    private Location location;
    private Timestamp time_start, time_end;
    private enum type {
        SINGLES_OPEN,
        SINGLES_CLOSE,
        DOUBLES_OPEN,
        DOUBLES_CLOSE
    }
    private List<Review> reviews;
    private Player organizer;
    private List<Player> players;
    private int freeSlots;
}
