package com.montini.teamsports;

import com.montini.teamsports.model.GameType;
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
    private static final Logger log = LoggerFactory.getLogger( PlayEvent.class );

    private SessionFactory sf;




    @Test
    public void test() {
        Session session = null;
        Transaction txn = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            txn = session.beginTransaction();

            Location l1 = new Location();
            l1.setId(1);
            l1.setName("Axel");
            l1.setAddress("balcikonio 9");
            l1.setMaxCourts(5);
            l1.setFreeCourts(4);

            PlayEvent playEvent = new PlayEvent();
            playEvent.setLocation(l1);
            playEvent.setEventDate("2019-12-11");
            playEvent.setTitle("kokoko");
            playEvent.setGameType(1);
            playEvent.setFreeSlots(4);

            PlayEvent playEvent2 = new PlayEvent();
            playEvent2.setLocation(l1);
            playEvent2.setEventDate("2019-12-11");
            playEvent2.setTitle("asasaas");
            playEvent2.setGameType(1);
            playEvent2.setFreeSlots(2);

            session.save(l1);
            session.save(playEvent);
            session.save(playEvent2);


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

