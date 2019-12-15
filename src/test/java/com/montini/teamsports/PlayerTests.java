package com.montini.teamsports;

import com.montini.teamsports.dao.UserRepository;
import com.montini.teamsports.dao.UserRepositoryImpl;
import com.montini.teamsports.model.Player;
import com.montini.teamsports.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PlayerTests {
    public static final Logger log = LoggerFactory.getLogger(Player.class);

    UserRepository userRepository = new UserRepositoryImpl();
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void test() {
        Session session = null;
        Transaction txn = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            txn = session.beginTransaction();

            User user = new User();
            user.setUsername("Ignas");
            user.setPassword(bCryptPasswordEncoder.encode("asdfg"));
            userRepository.add(user);



            session.save(user);

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
