package com.montini.teamsports;

import com.montini.teamsports.dao.UserRepository;
import com.montini.teamsports.model.Player;
import com.montini.teamsports.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration("classpath:resources")
@ComponentScan("com.montini.teamsports")

public class PlayerTests {

    public static final Logger log = LoggerFactory.getLogger(Player.class);

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    @Transactional
    public void test() throws Exception {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
                Date date1 = dateformat3.parse("17/07/1989");

            final User user = new User();
            user.setUsername("Ignas");
            user.setPassword(bCryptPasswordEncoder.encode("asdfg"));
            user.setDateCreated(date1);

            // start a transaction
            transaction = session.beginTransaction();

                log.info( "HBN:TEST " + user.toString() );
                entityManager.persist(user);


            transaction.commit();

        } catch (Exception e) {

            e.printStackTrace();
            throw e;
        }
    }
}
