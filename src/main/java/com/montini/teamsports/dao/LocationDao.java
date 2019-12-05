package com.montini.teamsports.dao;

import com.montini.teamsports.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationDao {
    public Location getLocation(int id);
    public List<Location> getAllLocation();
    public void deleteLocation(int id);
    public void updateLocation(Location location);
    public void saveLocation(Location location);
}
