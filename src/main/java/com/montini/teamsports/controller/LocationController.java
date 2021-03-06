package com.montini.teamsports.controller;


import com.montini.teamsports.model.Location;
import com.montini.teamsports.service.LocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "locations", method = RequestMethod.GET)
    public List<Location> list() {
        return locationService.getAllLocation();
    }

    @RequestMapping(value = "locations", method = RequestMethod.POST)
    public Location create(@RequestBody Location location) {
        return locationService.saveLocation(location);
    }

    @RequestMapping(value = "locations/{id}", method = RequestMethod.GET)
    public Serializable get(@PathVariable Integer id) {

        Location locationOptional = locationService.getLocation(id);
        return locationOptional;
    }

    @RequestMapping(value = "locations/{id}", method = RequestMethod.PUT)
    public Location update(@PathVariable int id, @RequestBody Location location) {
        Optional<Location> locationOptional = Optional.ofNullable(locationService.getLocation(id));
        Location existLocation = locationOptional.orElse(null);
        if (existLocation != null) {
            BeanUtils.copyProperties(location, existLocation);
            return locationService.saveLocation(existLocation);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "locations/{id}", method = RequestMethod.DELETE)
    public Location delete(@PathVariable int id) {
        Optional<Location> locationOptional = Optional.ofNullable(locationService.getLocation(id));
        Location existLocation = locationOptional.orElse(null);
        if (existLocation != null) {
            locationService.deleteLocation(id);
        }
        return existLocation;
    }
}
