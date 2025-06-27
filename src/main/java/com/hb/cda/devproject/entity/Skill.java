package com.hb.cda.devproject.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "skill")
    private List<DevMasterySkill> devMasterySkills = new ArrayList<>();
    
    public Skill() {
    }
    public Skill(String name, List<DevMasterySkill> devMasterySkills) {
        this.name = name;
        this.devMasterySkills = devMasterySkills;
    }
    public Skill(Integer id, String name, List<DevMasterySkill> devMasterySkills) {
        this.id = id;
        this.name = name;
        this.devMasterySkills = devMasterySkills;
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
    public List<DevMasterySkill> getDevMasterySkills() {
        return devMasterySkills;
    }
    public void setDevMasterySkills(List<DevMasterySkill> devMasterySkills) {
        this.devMasterySkills = devMasterySkills;
    }


}
