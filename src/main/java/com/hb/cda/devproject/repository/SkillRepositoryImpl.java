package com.hb.cda.devproject.repository;

import java.util.List;
import java.util.Optional;

import com.hb.cda.devproject.entity.Skill;
import com.hb.cda.devproject.repository.interfaces.SkillRepository;

import jakarta.persistence.EntityManager;

public class SkillRepositoryImpl extends GenericRepository<Skill> implements  SkillRepository{

        private EntityManager em = Database.getManager();

    @Override
    public boolean delete(Skill t) {
        try{
            em.getTransaction().begin();
        Skill toRemouve = em.find(Skill.class, t.getId());
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
    public List<Skill> findAll() {
        return em.createQuery("SELECT s FROM Skill s", Skill.class)
        .getResultList();
    }

    @Override
    public Optional<Skill> findById(int id) {
        try {
            Skill skill = em.find(Skill.class, id);
            return Optional.ofNullable(skill);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean persist(Skill t) {
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
    public boolean update(Skill t) {
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
    public Optional<Skill> findByName(String name) {
        try {
            Skill skill = em.createQuery(
                "SELECT s FROM Skill s WHERE s.name = :name", 
                Skill.class)
                .setParameter("name", name)
                .getSingleResult();
            return Optional.of(skill);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
