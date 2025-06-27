package com.hb.cda.devproject;

import com.hb.cda.devproject.entity.Developer;
import com.hb.cda.devproject.repository.DeveloperRepositoryimpl;


public class Main {
    public static void main(String[] args) {
        DeveloperRepositoryimpl repo = new DeveloperRepositoryimpl();

        Developer dev = new Developer();
        dev.getUser().setUsername("Sarah");
        dev.getUser().setEmail("sarah@exemple.com");

        repo.persist(dev);

        repo.findAll().forEach(d -> System.out.println(d.getUser().getUsername()));
    }
}
