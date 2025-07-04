package com.hb.cda.devproject;

import com.hb.cda.devproject.entity.ApplicationStatus;
import com.hb.cda.devproject.entity.DevMasterySkill;
import com.hb.cda.devproject.entity.Developer;
import com.hb.cda.devproject.entity.JobApplication;
import com.hb.cda.devproject.entity.MasteryLevel;
import com.hb.cda.devproject.entity.Project;
import com.hb.cda.devproject.entity.ProjectOwner;
import com.hb.cda.devproject.entity.ProjectStatus;
import com.hb.cda.devproject.entity.Skill;
import com.hb.cda.devproject.entity.User;
import com.hb.cda.devproject.repository.DevMasterySkillRepositoryImpl;
import com.hb.cda.devproject.repository.DeveloperRepositoryimpl;
import com.hb.cda.devproject.repository.JobApplicationRepositoryIpml;
import com.hb.cda.devproject.repository.ProjectOwnerRepositoryImpl;
import com.hb.cda.devproject.repository.ProjectRepositoryImpl;
import com.hb.cda.devproject.repository.SkillRepositoryImpl;
import com.hb.cda.devproject.repository.UserRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        UserRepositoryImpl userRepo = new UserRepositoryImpl();
        ProjectRepositoryImpl projectRepo = new ProjectRepositoryImpl();

        // Création d’un ProjectOwner
        User ownerUser = new User("owner1", "owner1@mail.com", "password");
        userRepo.persist(ownerUser);
        ProjectOwner owner = new ProjectOwner();
        owner.setUser(ownerUser);
        new ProjectOwnerRepositoryImpl().persist(owner);

        // Création d’un projet
        Project project = new Project();
        project.setName("Migration API");
        project.setDescription("Migration API Symfony vers Java Spring Boot");
        project.setProjectStatus(ProjectStatus.PENDING);
        project.setProjectOwner(owner);
        projectRepo.persist(project);

        // Création d’un développeur
        User devUser = new User("dev1", "dev1@mail.com", "password");
        userRepo.persist(devUser);
        Developer developer = new Developer();
        developer.setUser(devUser);
        new DeveloperRepositoryimpl().persist(developer);

        // Création d’une skill
        Skill javaSkill = new Skill();
        javaSkill.setName("Java");
        new SkillRepositoryImpl().persist(javaSkill);

        // Attribution de compétence à un développeur
        DevMasterySkill devSkill = new DevMasterySkill();
        devSkill.setDeveloper(developer);
        devSkill.setSkill(javaSkill);
        devSkill.setMasteryLevel(MasteryLevel.SENIOR);
        new DevMasterySkillRepositoryImpl().persist(devSkill);

        // Candidature à un projet
        JobApplication application = new JobApplication();
        application.setDeveloper(developer);
        application.setProject(project);
        application.setApplicationStatus(ApplicationStatus.PENDING);
        new JobApplicationRepositoryIpml().persist(application);

        System.out.println("Enregistrements terminés avec succès !");
    }
}
