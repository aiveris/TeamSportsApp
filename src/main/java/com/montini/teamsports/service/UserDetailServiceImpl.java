package com.montini.teamsports.service;

import com.montini.teamsports.dao.UserRepository;
import com.montini.teamsports.model.AppUserDetails;
import com.montini.teamsports.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Autowired

    private UserRepository userRepository;

    @Transactional(readOnly = true)

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.getUserByUsername(username);

        if (user == null) {

            throw new UsernameNotFoundException("User not found.");

        }

        log.info("loadUserByUsername() : {}", username);

        return new AppUserDetails(user);

    }
}
