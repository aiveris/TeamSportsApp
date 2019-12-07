package com.montini.teamsports.dao;

import com.montini.teamsports.model.Location;

import java.util.List;

public interface LocationDao {
    public Location getLocation(Integer id);
    public List<Location> getAllLocation();
    public void deleteLocation(Location id);
    public void updateLocation(Location location);
    public Location saveLocation(Location location);
}
