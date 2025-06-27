package com.hb.cda.devproject.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
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
    private Status status;
    @OneToMany(mappedBy = "project")
    private List<JobApplication> jobApplications = new ArrayList<>();
    @ManyToOne
@JoinColumn(name = "project_owner_id")
private ProjectOwner projectOwner;
    
    public Project() {
    }
    public Project(Integer id, String name, String description, Status status, List<JobApplication> jobApplications) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.jobApplications = jobApplications;
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
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }
    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((jobApplications == null) ? 0 : jobApplications.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Project other = (Project) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (status != other.status)
            return false;
        if (jobApplications == null) {
            if (other.jobApplications != null)
                return false;
        } else if (!jobApplications.equals(other.jobApplications))
            return false;
        return true;
    }

}
