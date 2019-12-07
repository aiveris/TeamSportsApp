package com.montini.teamsports.dao;

import com.montini.teamsports.HibernateUtil;
import com.montini.teamsports.model.Location;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component("locationDao")

public class LocationDaoImpl implements LocationDao {

    @Autowired
    Location location;


    public Location saveLocation(Location location) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(location);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return location;
    }

    /**
     * Update Location
     *
     * @param location
     */
    public void updateLocation(Location location) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(location);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete Instructor
     *
     * @param id
     */
    public void deleteLocation(Location id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a location object
            Location location = session.get(Location.class, (Serializable) id);
            if (location != null) {
                session.delete(location);
                System.out.println("instructor is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get Location By ID
     *
     * @param id
     * @return
     */
    public Location getLocation(Integer id) {

        Transaction transaction = null;
        Location location = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an instructor object
            location = session.get(Location.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {

            e.printStackTrace();

            if (transaction != null) {
            //    transaction.rollback();
            }
            e.printStackTrace();
        }
        return location;
    }

    /**
     * Get all Location
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Location> getAllLocation() {

        Transaction transaction = null;
        List<Location> listOfLocation = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an instructor object

            listOfLocation = session.createQuery("from Location").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfLocation;
    }
}
