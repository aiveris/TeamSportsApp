package com.montini.teamsports.dao;

import com.montini.teamsports.HibernateUtil;
import com.montini.teamsports.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    @Transactional
    public Integer add(Object user) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // start a transaction
            transaction = session.beginTransaction();
            session.save(user);

        }catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return ((User)user).getId();
    }

    @Override
    @Transactional
    public void delete(Object o) {
    }

    @Override
    @Transactional
    public Object update(Object o) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return o;
    }

    @Override
    @Transactional
    public User findOne(Integer id) {

        Transaction transaction = null;
        User userNow = new User();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            userNow = session.get(User.class, id);

        } catch (Exception e) {

        if (transaction != null) {
            transaction.rollback();
        }
            e.printStackTrace();
        }
        return userNow;
    }

    @Override
    @Transactional
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
    @Transactional
    public User getUserByUsername(String username) {
        Transaction transaction = null;
        Query<User> query = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

        query = session.createQuery("FROM User WHERE username=:bind_username", User.class);
        query.setParameter("bind_username", username);

        transaction.commit();

        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return query.uniqueResult();
    }

    @Override
    @Transactional
    public List<User> getAllAdmins() {
        Transaction transaction = null;
        NativeQuery<User> query = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            query = session.createNativeQuery(
              "SELECT * FROM user u, user_authority ua, authority a WHERE u.id=ua.user_id AND a.id = ua.authority_id AND a.name=:role");

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

