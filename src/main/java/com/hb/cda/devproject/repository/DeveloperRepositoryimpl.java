package com.hb.cda.devproject.repository;

import java.util.List;
import java.util.Optional;

import com.hb.cda.devproject.entity.Developer;
import com.hb.cda.devproject.entity.Project;
import com.hb.cda.devproject.repository.interfaces.DeveloperRepository;

import jakarta.persistence.EntityManager;

public class DeveloperRepositoryimpl extends GenericRepository<Developer> implements DeveloperRepository {

    private EntityManager em = Database.getManager();

    public Optional<Developer> getByUserName(String username){
        try {
            Developer dev = em.createQuery("SELECT d FROM Developer d WHERE d.user.username = :username", Developer.class)
            .setParameter("username", username)
            .getSingleResult();
            return Optional.of(dev);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    
    }
  

    @Override
    public boolean delete(Developer t) {
        try{
            em.getTransaction().begin();
            Developer toRemouve = em.find(Developer.class, t.getId());
            if(toRemouve != null){
                em.remove(toRemouve);
                em.getTransaction().commit();
                return true;
            }
            else{
                em.getTransaction().rollback();
                return false;
            }
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Developer> findAll() {
        return em.createQuery("SELECT d FROM Developer d", Developer.class).getResultList();

    }

    @Override
    public Optional<Developer> findById(int id) {
        try {
            Developer dev = em.find(Developer.class, id);
            return Optional.ofNullable(dev);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean persist(Developer t) {
        try{
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return true;
        }catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Developer t) {
        try {
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        return true;

        } catch (Exception e){
        em.getTransaction().rollback();
        e.printStackTrace();
        return false;
    }
}


}
