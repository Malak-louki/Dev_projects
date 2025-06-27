package com.hb.cda.devproject.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String description;
    @OneToMany(mappedBy = "developer")
    private List<JobApplication> jobApplications = new ArrayList<>();
    @OneToMany(mappedBy = "developer")
    private List<DevMasterySkill> devMasterySkill = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "user_id") // FK en bdd
    private User user;

    public Developer() {
        }
    public Developer(String description, List<JobApplication> jobApplications,
                List<DevMasterySkill> devMasterySkill, User user) {
            this.description = description;
            this.jobApplications = jobApplications;
            this.devMasterySkill = devMasterySkill;
            this.user = user;
        }
    public Developer(Integer id, String description, List<JobApplication> jobApplications,
                List<DevMasterySkill> devMasterySkill, User user) {
            this.id = id;
            this.description = description;
            this.jobApplications = jobApplications;
            this.devMasterySkill = devMasterySkill;
            this.user = user;
        }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<JobApplication> getJobapplications() {
        return jobApplications;
    }

    public void setJobapplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }
    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }
    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }
    public List<DevMasterySkill> getDevMasterySkill() {
        return devMasterySkill;
    }
    public void setDevMasterySkill(List<DevMasterySkill> devMasterySkill) {
        this.devMasterySkill = devMasterySkill;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Developer [id=" + id + ", description=" + description + ", jobApplications=" + jobApplications
                + ", devMasterySkill=" + devMasterySkill + ", user=" + user + "]";
    }

}
