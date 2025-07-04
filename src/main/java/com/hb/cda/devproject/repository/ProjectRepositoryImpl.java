package com.hb.cda.devproject.repository;

import java.util.List;
import java.util.Optional;

import com.hb.cda.devproject.entity.Project;
import com.hb.cda.devproject.entity.ProjectOwner;
import com.hb.cda.devproject.entity.ProjectStatus;
import com.hb.cda.devproject.repository.interfaces.ProjectRepository;

import jakarta.persistence.EntityManager;

public class ProjectRepositoryImpl extends GenericRepository<Project> implements ProjectRepository {

    private EntityManager em = Database.getManager();

    @Override
    public List<Project> findAll() {
        return em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
    }

    @Override
    public Optional<Project> findById(int id) {
        try {
            Project dev = em.find(Project.class, id);
            return Optional.ofNullable(dev);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean persist(Project t) {
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
    public boolean delete(Project t) {
        try {
            em.getTransaction().begin();
            Project toRemouve = em.find(Project.class, t.getId());
            if(toRemouve != null){
                em.remove(toRemouve);
            em.getTransaction().commit();
            return true;
            }else{
                em.getTransaction().rollback();
                return false;
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
            
        }
    }

    @Override
    public boolean update(Project t) {
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

    @Override
    public List<Project> findByStatus(ProjectStatus status) {
        try {
            return em.createQuery(
                "SELECT p FROM Project p WHERE p.projectStatus = :status", 
                Project.class)
                .setParameter("status", status)
                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<Project> findAvailableProjects() {
        try {
            return em.createQuery(
                "SELECT p FROM Project p WHERE p.projectStatus = :status", 
                Project.class)
                .setParameter("status", ProjectStatus.PENDING)
                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<Project> findByProjectOwnerAndStatus(ProjectOwner owner, ProjectStatus status) {
        try {
            return em.createQuery(
                "SELECT p FROM Project p WHERE p.projectOwner = :owner AND p.projectStatus = :status", 
                Project.class)
                .setParameter("owner", owner)
                .setParameter("status", status)
                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

}
