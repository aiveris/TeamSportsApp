package com.montini.teamsports.service;

import com.montini.teamsports.model.Location;

import java.util.List;

public interface LocationService {
    public Location getLocation(long id);
    public List<Location> getAllLocation();
    public void deleteLocation(Location id);
    public void updateLocation(Location location);
    public Location saveLocation(Location location);
}
