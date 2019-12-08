package com.montini.teamsports.dao;

import com.montini.teamsports.model.Location;

import java.util.List;

public interface LocationDao {

    public Location getLocation(Integer id);
    public List<Location> getAllLocation();
    public void deleteLocation(Integer id);
    public void updateLocation(Location location);
    public Location saveLocation(Location location);
    public void saveLocation(Location location, boolean testing);


}
