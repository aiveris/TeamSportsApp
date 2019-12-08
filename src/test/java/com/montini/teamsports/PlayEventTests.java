package com.montini.teamsports;

import com.montini.teamsports.model.Location;
import com.montini.teamsports.model.PlayEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.Calendar;

public class PlayEventTests {
    private static final Logger log = LoggerFactory.getLogger( Location.class );

    private SessionFactory sf;




    @Test
    public void test() {
        Session session = null;
        Transaction txn = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            txn = session.beginTransaction();

            PlayEvent playEvent = new PlayEvent();
            playEvent.setEventDate(new Date(Calendar.getInstance().getTime().getTime()));

            session.persist(playEvent);

            txn.commit();
        } catch (RuntimeException e) {
            if ( txn != null && txn.isActive() ) txn.rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}

