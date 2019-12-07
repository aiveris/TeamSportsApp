package com.montini.teamsports.dao;

import com.montini.teamsports.HibernateUtil;
import com.montini.teamsports.model.PlayEvent;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayEventDaoImpl implements PlayEventDao {

    @Autowired
    PlayEvent playEvent;


    public void savePlayEvent(PlayEvent playEvent) {
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
    }

    /**
     * Update PlayEvent
     * @param playEvent
     */
    public void updatePlayEvent(PlayEvent playEvent) {
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
    public void deletePlayEvent(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a PlayEvent object
            PlayEvent playEvent = session.get(PlayEvent.class, id);
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
    public PlayEvent getPlayEvent(int id) {

        Transaction transaction = null;
        PlayEvent playEvent = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an instructor object
            playEvent = session.get(PlayEvent.class, id);
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
     * Get all Location.xml
     * @return
     */
    @SuppressWarnings("unchecked")
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