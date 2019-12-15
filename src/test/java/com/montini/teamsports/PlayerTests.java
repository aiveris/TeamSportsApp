package com.montini.teamsports;

import com.montini.teamsports.dao.UserRepository;
import com.montini.teamsports.dao.UserRepositoryImpl;
import com.montini.teamsports.model.Authority;
import com.montini.teamsports.model.AuthorityType;
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

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration("classpath:resources")
@ComponentScan("com.montini.teamsports")

public class PlayerTests {

    public static final Logger log = LoggerFactory.getLogger(Player.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void test() {

        try {

            final User user = new User();
            user.setUsername("Ignas");
            user.setPassword(bCryptPasswordEncoder.encode("asdfg"));

            log.info( "HBN:USER LOG " + user.toString() );

            userRepository.add(user);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
