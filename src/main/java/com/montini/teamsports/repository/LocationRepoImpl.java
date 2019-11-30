package com.montini.teamsports.repository;

import com.montini.teamsports.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LocationRepoImpl {

    public static final Logger log = LoggerFactory.getLogger(LocationRepoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    // Create
    public Location create(Location location) {
        entityManager.persist(location);
        entityManager.flush();
        return location;
    }

    // Update
    public Location update(Location location) {
        location = entityManager.merge(location);
        entityManager.flush();
        return location;
    }

    // Delete
    public void delete(Location location) {
        entityManager.remove(location);
        entityManager.flush();
    }

    // Find
    public Location find(Integer id) {
        log.info(String.format("FIND #%d in", id) + this.getClass().getCanonicalName());
        return entityManager.find(Location.class, id);
    }

    public Location findById(Integer id) {
        return this.find(id);
    }

    public Location findAll(Integer id) {
        return entityManager.find(Location.class, id);
    }

}
