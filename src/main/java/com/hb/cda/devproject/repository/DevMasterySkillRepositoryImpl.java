package com.hb.cda.devproject.repository;

import java.util.List;
import java.util.Optional;

import com.hb.cda.devproject.entity.DevMasterySkill;
import com.hb.cda.devproject.entity.MasteryLevel;
import com.hb.cda.devproject.repository.interfaces.DevMasterySkillRepository;

import jakarta.persistence.EntityManager;

public class DevMasterySkillRepositoryImpl extends GenericRepository<DevMasterySkill> implements DevMasterySkillRepository{

        private EntityManager em = Database.getManager();

    @Override
    public boolean delete(DevMasterySkill t) {
        try{
            em.getTransaction().begin();
        DevMasterySkill toRemouve = em.find(DevMasterySkill.class, t.getId());
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
    public List<DevMasterySkill> findAll() {
        return em.createQuery("SELECT d FROM DevMasterySkill d", DevMasterySkill.class)
        .getResultList();
    }

    @Override
    public Optional<DevMasterySkill> findById(int id) {
        try {
            DevMasterySkill devMasterySkill = em.find(DevMasterySkill.class, id);
            return Optional.ofNullable(devMasterySkill);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean persist(DevMasterySkill t) {
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
    public boolean update(DevMasterySkill t) {
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
    public List<DevMasterySkill> findByDeveloperId(Integer developerId) {
        try {
            return em.createQuery(
                "SELECT d FROM DevMasterySkill d WHERE d.developer.id = :developerId", 
                DevMasterySkill.class)
                .setParameter("developerId", developerId)
                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<DevMasterySkill> findBySkillId(Integer skillId) {
        try {
            return em.createQuery(
                "SELECT d FROM DevMasterySkill d WHERE d.skill.id = :skillId", 
                DevMasterySkill.class)
                .setParameter("skillId", skillId)
                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<DevMasterySkill> findBySkillIdAndMasteryLevel(Integer skillId, MasteryLevel level) {
        try {
            return em.createQuery(
                "SELECT d FROM DevMasterySkill d WHERE d.skill.id = :skillId AND d.masteryLevel = :level", 
                DevMasterySkill.class)
                .setParameter("skillId", skillId)
                .setParameter("level", level)
                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

}
