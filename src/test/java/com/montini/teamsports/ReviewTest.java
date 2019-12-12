package com.montini.teamsports;

import com.montini.teamsports.model.Player;
import com.montini.teamsports.model.Review;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
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



            Player player = new Player();
            player.setUsername("Ignas");
            player.setPassword("kokokok");
            player.setEmail("jojo@jojo.com");
            player.setUserType(0);
            player.setRank(10);


            Review review = new Review();
            review.setTimestamp(new Timestamp(System.currentTimeMillis()));
            review.setDescription("New message from team-sport user.");

            session.save(player);
            session.save(review);

            transaction.commit();


        } catch (RuntimeException e) {

            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
