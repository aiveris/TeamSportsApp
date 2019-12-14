package com.montini.teamsports.dao;

import com.montini.teamsports.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired

    private SessionFactory sessionFactory;

    @Override

    public User getUserByUsername(String username) {

        Query<User> query = sessionFactory.getCurrentSession().createQuery("FROM User u where u.username=:username", User.class);

        query.setParameter("username", username);

        return query.uniqueResult();

    }

}

