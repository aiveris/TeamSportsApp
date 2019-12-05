package com.montini.teamsports;

import com.montini.teamsports.model.Review;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Timestamp;


public class ReviewTest {

    public static final Logger log = LoggerFactory.getLogger(Review.class);

    @Test
    public void test1() {

        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Review review = new Review();
            review.setTimestamp(new Timestamp(System.currentTimeMillis()));
            review.setDescription("New message from team-sport user.");
            session.persist(review);
            transaction.commit();

        } catch (RuntimeException e) {
            if ( transaction != null && transaction.isActive() ) transaction.rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
