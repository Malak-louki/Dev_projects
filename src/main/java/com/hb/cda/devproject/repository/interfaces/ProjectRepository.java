package com.hb.cda.devproject.repository.interfaces;

import java.util.List;

import com.hb.cda.devproject.entity.Project;
import com.hb.cda.devproject.entity.ProjectOwner;
import com.hb.cda.devproject.entity.ProjectStatus;

public interface ProjectRepository extends  GenericRepositoryInterface<Project> {
        // Projets par statut
List<Project> findByStatus(ProjectStatus status);

// Projets disponibles (PENDING)
List<Project> findAvailableProjects();

// Projets d'un propriétaire par statut
List<Project> findByProjectOwnerAndStatus(ProjectOwner owner, ProjectStatus status);


}
