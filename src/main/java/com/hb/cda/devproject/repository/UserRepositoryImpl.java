package com.hb.cda.devproject.repository;

import java.util.List;
import java.util.Optional;

import com.hb.cda.devproject.entity.User;
import com.hb.cda.devproject.repository.interfaces.UserRepository;

import jakarta.persistence.EntityManager;

public class UserRepositoryImpl extends GenericRepository<User> implements UserRepository {

    private EntityManager em = Database.getManager();

    @Override
    public boolean delete(User t) {
        try{
            em.getTransaction().begin();
        User toRemouve = em.find(User.class, t.getId());
        em.remove(toRemouve);
        em.getTransaction().commit();
        return true;
        }catch (Exception e) {
            em.getTransaction().rollback();

            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class)
        .getResultList();
    }

    @Override
    public Optional<User> findById(int id) {
        try {
            User user = em.find(User.class, id);
            return Optional.ofNullable(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean persist(User t) {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(User t) {
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Optional<User> findByEmail(String email) {
        try {
            User user = em.createQuery(
                "SELECT u FROM User u WHERE u.email = :email", 
                User.class)
                .setParameter("email", email)
                .getSingleResult();
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try {
            User user = em.createQuery(
                "SELECT u FROM User u WHERE u.username = :username", 
                User.class)
                .setParameter("username", username)
                .getSingleResult();
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
