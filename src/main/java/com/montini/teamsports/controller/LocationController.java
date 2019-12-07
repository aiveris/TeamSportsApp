package com.montini.teamsports.controller;


import com.montini.teamsports.dao.LocationDao;
import com.montini.teamsports.dao.LocationDaoImpl;
import com.montini.teamsports.model.Location;
import com.montini.teamsports.service.LocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class LocationController {

    @Autowired
    private LocationDao locationDao;

    @RequestMapping(value = "locations", method = RequestMethod.GET)
    public List<Location> list() {
        return locationDao.getAllLocation();
    }

    @RequestMapping(value = "locations", method = RequestMethod.POST)
    public Location create(@RequestBody Location location) {
        return locationDao.saveLocation(location);
    }

    @RequestMapping(value = "locations/{id}", method = RequestMethod.GET)
    public Location get(@PathVariable int id) {
        Optional<Location> locationOptional = Optional.ofNullable(locationDao.getLocation(id));
        return locationOptional.orElse(null);
    }

    @RequestMapping(value = "locations/{id}", method = RequestMethod.PUT)
    public Location update(@PathVariable int id, @RequestBody Location location) {
        Optional<Location> locationOptional = Optional.ofNullable(locationDao.getLocation(id));
        Location existLocation = locationOptional.orElse(null);
        if (existLocation != null) {
            BeanUtils.copyProperties(location, existLocation);
            return locationDao.saveLocation(existLocation);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "locations/{id}", method = RequestMethod.DELETE)
    public Location delete(@PathVariable int id) {
        Optional<Location> locationOptional = Optional.ofNullable(locationDao.getLocation(id));
        Location existLocation = locationOptional.orElse(null);
        if (existLocation != null) {
            locationDao.deleteLocation(existLocation);
        }
        return existLocation;
    }
}
