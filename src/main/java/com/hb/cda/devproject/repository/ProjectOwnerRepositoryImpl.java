package com.hb.cda.devproject.repository;

import java.util.List;
import java.util.Optional;

import com.hb.cda.devproject.entity.ProjectOwner;
import com.hb.cda.devproject.repository.interfaces.ProjectOwnerRepository;

import jakarta.persistence.EntityManager;

public class ProjectOwnerRepositoryImpl extends GenericRepository<ProjectOwner> implements ProjectOwnerRepository
{

    private EntityManager em = Database.getManager();

    @Override
    public boolean delete(ProjectOwner t) {
        try{
            em.getTransaction().begin();
        ProjectOwner toRemouve = em.find(ProjectOwner.class, t.getId());
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
    public List<ProjectOwner> findAll() {
        return em.createQuery("SELECT p FROM ProjectOwner p", ProjectOwner.class)
        .getResultList();
    }

    @Override
    public Optional<ProjectOwner> findById(int id) {
        try {
            ProjectOwner po = em.find(ProjectOwner.class, id);
            return Optional.ofNullable(po);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean persist(ProjectOwner t) {
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
    public boolean update(ProjectOwner t) {
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
    public Optional<ProjectOwner> getByUserName(String username) {
        try {
            ProjectOwner po = em.createQuery("SELECT p FROM ProjectOwner p WHERE p.user.username = :username", ProjectOwner.class)
            .setParameter("username", username)
            .getSingleResult();
            return Optional.of(po);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    
    }
}
