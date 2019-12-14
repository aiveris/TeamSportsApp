package com.montini.teamsports.dao;

import com.montini.teamsports.HibernateUtil;
import com.montini.teamsports.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Override
    public Integer add(Object user) {
        return (Integer) HibernateUtil.getSessionFactory().getCurrentSession().save(user);
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public User findOne(Integer id) {
        return HibernateUtil.getSessionFactory().getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> findAll() {
        Transaction transaction = null;
        List<User> users = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            users = session.createQuery("FROM User", User.class).list();
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getUserByUsername(String username) {
        Transaction transaction;
        Query<User> query = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

        query = session.createQuery("FROM User u where u.username=:username", User.class);
        query.setParameter("username", username);

        transaction.commit();


        }catch (Exception e) {

            e.printStackTrace();
        }

        return query.uniqueResult();
    }

    @Override
    public List<User> getAllAdmins() {
        Transaction transaction = null;
        NativeQuery<User> query = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            query = session.createNativeQuery("SELECT * FROM user u where id in (select user_id FROM user_authority where authority_id=(select id FROM authority where name=:role))");
            query.setParameter("role", "ROLE_ADMIN");
            query.addEntity(User.class);

            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return query.list();
    }
}

