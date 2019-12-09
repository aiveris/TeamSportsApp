package com.montini.teamsports.dao;

import com.montini.teamsports.HibernateUtil;
import com.montini.teamsports.model.Location;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class LocationDaoImpl implements LocationDao {

    private static Logger logger = LoggerFactory.getLogger( LocationDaoImpl.class );

    @Transactional
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

    @Override
    public void saveLocation(Location location, boolean testing) {
        this.saveLocation(location);
    }

    /**
     * Update Location
     *
     * @param location
     */

    @Transactional
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
    @Transactional
    public void deleteLocation(Integer id) {

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
    @Transactional
    public Location getLocation(Integer id) {

        Transaction transaction = null;
        Location location = new Location();
        Optional<Location> optionalLocation = Optional.of( location );

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an instructor object

            TypedQuery<Location> query = session.createQuery("from Location L where L.id = :location_id",
                    Location.class);

            query.setParameter("location_id", id);
            List<Location> results = query.getResultList();

            Iterator<Location> ii = results.iterator();
            while (ii.hasNext()) {
                optionalLocation = Optional.of( ii.next() );
                break;
            }

            // commit transaction
            transaction.commit();

        } catch ( ClassCastException e ) {

            e.printStackTrace();
            logger.error( e.getMessage() );

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return optionalLocation.get();
    }


    /**
     * Get all Location
     *
     * @return
     */
    @SuppressWarnings("unchecked")

    @Transactional
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
