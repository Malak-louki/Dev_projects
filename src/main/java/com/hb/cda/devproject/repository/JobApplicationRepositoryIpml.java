package com.hb.cda.devproject.repository;

import java.util.List;
import java.util.Optional;

import com.hb.cda.devproject.entity.ApplicationStatus;
import com.hb.cda.devproject.entity.JobApplication;
import com.hb.cda.devproject.repository.interfaces.JobApplicationRepository;

import jakarta.persistence.EntityManager;

public class JobApplicationRepositoryIpml extends GenericRepository<JobApplication> implements JobApplicationRepository{
    private EntityManager em = Database.getManager();

    @Override
    public boolean delete(JobApplication t) {
        try{
        em.getTransaction().begin();
        JobApplication toRemouve = em.find(JobApplication.class, t.getId());
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
    public List<JobApplication> findAll() {
        return em.createQuery("SELECT j FROM JobApplication j", JobApplication.class).getResultList();
    }

    @Override
    public Optional<JobApplication> findById(int id) {
        try {
            JobApplication job = em.find(JobApplication.class, id);
            return Optional.ofNullable(job);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean persist(JobApplication t) {
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
    public boolean update(JobApplication t) {
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
    public Optional<JobApplication> getbyUserName(String username) {
    try {
            JobApplication job = em.createQuery(
                "SELECT j FROM JobApplication j WHERE j.developer.user.username = :username", 
                JobApplication.class)
                .setParameter("username", username)
                .getSingleResult();
            return Optional.of(job);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<JobApplication> findByProjectId(Integer projectId) {
        try {
            return em.createQuery(
                "SELECT j FROM JobApplication j WHERE J.project.id = :project_id", JobApplication.class)
                .setParameter("project_id", projectId)
                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<JobApplication> findByDeveloperId(Integer developerId) {
            try {
            return em.createQuery(
                "SELECT j FROM JobApplication j WHERE j.developer.id = :developerId", 
                JobApplication.class)
                .setParameter("developer_id", developerId)
                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<JobApplication> findByStatus(ApplicationStatus status) {
            try {
            return em.createQuery(
                "SELECT j FROM JobApplication j WHERE j.applicationStatus = :status", 
                JobApplication.class)
                .setParameter("status", status)
                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<JobApplication> findByProjectIdAndStatus(Integer projectId, ApplicationStatus status) {
            try {
            return em.createQuery(
                "SELECT j FROM JobApplication j WHERE j.project.id = :projectId AND j.applicationStatus = :status", 
                JobApplication.class)
                .setParameter("projectId", projectId)
                .setParameter("status", status)
                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public Long countByProjectId(Integer projectId) {
            try {
            return em.createQuery(
                "SELECT COUNT(j) FROM JobApplication j WHERE j.project.id = :projectId", 
                Long.class)
                .setParameter("projectId", projectId)
                .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
