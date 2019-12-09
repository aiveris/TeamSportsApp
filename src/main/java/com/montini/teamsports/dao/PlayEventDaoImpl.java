package com.montini.teamsports.dao;

import com.montini.teamsports.HibernateUtil;
import com.montini.teamsports.model.PlayEvent;
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
public class PlayEventDaoImpl implements PlayEventDao {

    private static Logger logger = LoggerFactory.getLogger( PlayEventDaoImpl.class );

    @Transactional
    public PlayEvent savePlayEvent(PlayEvent playEvent) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(playEvent);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return playEvent;
    }

    /**
     * Update PlayEvent
     * @param playEvent
     */

    @Transactional
    public void updatePlayEvent(Integer playEvent) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the PlayEvent object
            session.update(playEvent);
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
     * Delete PlayEvent
     * @param id
     */
    @Transactional
    public void deletePlayEvent(PlayEvent id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a PlayEvent object
            PlayEvent playEvent = session.get(PlayEvent.class, (Serializable) id);
            if (playEvent != null) {
                session.delete(playEvent);
                System.out.println("playEvent is deleted");
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
     * Get PlayEvent By ID
     * @param id
     * @return
     */
    @Transactional
    public PlayEvent getPlayEvent(Integer id) {

        Transaction transaction = null;
        PlayEvent playEvent = new PlayEvent();
        Optional<PlayEvent> optionalPlayEvent = Optional.of( playEvent );

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an instructor object

            TypedQuery<PlayEvent> query = session.createQuery("from PlayEvent L where L.id = :playEvent_id",
                    PlayEvent.class);

            query.setParameter("playEvent_id", id);
            List<PlayEvent> results = query.getResultList();

            Iterator<PlayEvent> ii = results.iterator();
            while (ii.hasNext()) {
                optionalPlayEvent = Optional.of( ii.next() );
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

        return optionalPlayEvent.get();
    }

    /**
     * Get all PlayEvent.xml
     * @return
     */
    @SuppressWarnings("unchecked")
    @Transactional
    public List<PlayEvent> getAllPlayEvent() {

        Transaction transaction = null;
        List<PlayEvent> listOfPlayEvent = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an playEvent object

            listOfPlayEvent = session.createQuery("from PlayEvent").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfPlayEvent;
    }
}
