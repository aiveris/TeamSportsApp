package com.montini.teamsports.service;


import com.montini.teamsports.dao.LocationDao;
import com.montini.teamsports.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDao locationDao;

    @Override
    public Location getLocation(Integer id) {
        return this.locationDao.getLocation(id);
    }

    @Override
    public List<Location> getAllLocation() {
        return this.locationDao.getAllLocation();
    }

    @Override
    public void deleteLocation(Integer id) {
        this.locationDao.deleteLocation(id);
    }

    @Override
    public void updateLocation(Location location) {
        this.locationDao.updateLocation(location);
    }

    @Override
    public Location saveLocation(Location location) {
        this.locationDao.saveLocation(location);
        return location;
    }
}
