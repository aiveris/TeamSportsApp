package com.montini.teamsports.dao;

import com.montini.teamsports.HibernateUtil;
import com.montini.teamsports.model.PlayEvent;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PlayEventDaoImpl implements PlayEventDao {

    @Override
    public PlayEvent get(int id) {
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

    @Override
    public List<PlayEvent> getAll() {
        Transaction transaction = null;
        List<PlayEvent> listOfPlayEvent = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an instructor object

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
