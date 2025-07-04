package com.hb.cda.devproject.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class JobApplication {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String message;
    private LocalDate date;
    @Enumerated(EnumType.STRING) 
    private ApplicationStatus applicationStatus;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;
    public JobApplication() {
    }
    public JobApplication(String message, LocalDate date, ApplicationStatus applicationStatus, Project project, Developer developer) {
        this.message = message;
        this.date = date;
        this.applicationStatus = applicationStatus;
        this.project = project;
        this.developer = developer;
    }
    public JobApplication(Integer id, String message, LocalDate date, ApplicationStatus applicationStatus, Project project,
            Developer developer) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.applicationStatus = applicationStatus;
        this.project = project;
        this.developer = developer;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }
    public Developer getDeveloper() {
        return developer;
    }
    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
        public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }
    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        return result;
    }



    
}
