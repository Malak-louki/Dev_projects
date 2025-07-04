package com.hb.cda.devproject.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING) 
    private ProjectStatus projectStatus;

    @OneToMany(mappedBy = "project")
    private List<JobApplication> jobApplications = new ArrayList<>();
    @ManyToOne
@JoinColumn(name = "project_owner_id")
private ProjectOwner projectOwner;
    
    public Project() {
    }
    public Project(String name, String description, ProjectStatus projectStatus, List<JobApplication> jobApplications,
            ProjectOwner projectOwner) {
        this.name = name;
        this.description = description;
        this.projectStatus = projectStatus;
        this.jobApplications = jobApplications;
        this.projectOwner = projectOwner;
    }

    public Project(Integer id, String name, String description, ProjectStatus projectStatus,
            List<JobApplication> jobApplications, ProjectOwner projectOwner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.projectStatus = projectStatus;
        this.jobApplications = jobApplications;
        this.projectOwner = projectOwner;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }
    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }
    @Override
    public int hashCode() {
    return (id != null) ? id.hashCode() : 0;
}
    @Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null || getClass() != obj.getClass())
        return false;
    Project other = (Project) obj;
    return id != null && id.equals(other.getId());
}


public ProjectStatus getProjectStatus() {
    return projectStatus;
}
public void setProjectStatus(ProjectStatus projectStatus) {
    this.projectStatus = projectStatus;
}
public ProjectOwner getProjectOwner() {
    return projectOwner;
}
public void setProjectOwner(ProjectOwner projectOwner) {
    this.projectOwner = projectOwner;
}
@Override
public String toString() {
    return "Project [id=" + id + ", name=" + name + ", description=" + description + ", projectStatus=" + projectStatus
            + ", projectOwner=" + projectOwner + "]";
}

}
