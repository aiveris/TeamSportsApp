package com.montini.teamsports.dao;

import com.montini.teamsports.HibernateUtil;
import com.montini.teamsports.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Logger log = LoggerFactory.getLogger( UserRepositoryImpl.class );

    @Override
    @Transactional
    public Integer add(User user) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // start a transaction
            transaction = session.beginTransaction();
            session.save(user);

            transaction.commit();
        }catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return ((User)user).getId();
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    @Transactional
    public void delete(User o) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public User update(User o) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            transaction.commit();

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

            transaction = session.beginTransaction();
            userNow = session.get(User.class, id);
            transaction.commit();

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
        List<User> users = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.createQuery("FROM User", User.class);
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
        TypedQuery<User> query = null;

        log.info( "HBN:USER " + username );

        Optional<User> optionalUser = Optional.of( new User() );

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

        query = session.createQuery("FROM User WHERE username=:bind_username", User.class);
        query.setParameter("bind_username", username);

            List<User> results = query.getResultList();

            Iterator<User> ii = results.iterator();
            while (ii.hasNext()) {
                optionalUser = Optional.of( ii.next() );
                break;
            }

        transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return optionalUser.get();
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

