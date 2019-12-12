package com.montini.teamsports;

import com.montini.teamsports.model.Player;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerTests {
    public static final Logger log = LoggerFactory.getLogger(Player.class);

    @Test
    public void test() {
        Session session = null;
        Transaction txn = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            txn = session.beginTransaction();

            Player player = new Player();
            player.setUsername("montini");
            player.setPassword("energy");
            player.setEmail("lemontini@gmail.com");
            player.setUserType(0);
            player.setRank(1);




            session.save(player);

            txn.commit();
        } catch (RuntimeException e) {
            if (txn != null && txn.isActive()) txn.rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
