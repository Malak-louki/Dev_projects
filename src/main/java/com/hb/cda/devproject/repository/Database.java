package com.hb.cda.devproject.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Database {

    private static EntityManager em;

    public static EntityManager getManager() {
        if(em == null) {
            em = Persistence
                .createEntityManagerFactory("main").createEntityManager();
        }

        return em;
    }

    public static void reset() {
        em = null;
    }
}
