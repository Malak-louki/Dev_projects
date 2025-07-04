package com.hb.cda.devproject.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.hb.cda.devproject.entity.ApplicationStatus;
import com.hb.cda.devproject.entity.JobApplication;

public interface JobApplicationRepository extends  GenericRepositoryInterface<JobApplication> {

public Optional<JobApplication> getbyUserName(String username);
// Candidatures par projet
List<JobApplication> findByProjectId(Integer projectId);

// Candidatures par développeur
List<JobApplication> findByDeveloperId(Integer developerId);

// Candidatures par statut
List<JobApplication> findByStatus(ApplicationStatus status);

// Candidatures d'un projet par statut
List<JobApplication> findByProjectIdAndStatus(Integer projectId, ApplicationStatus status);

// Nombre de candidatures par projet
Long countByProjectId(Integer projectId);
}
