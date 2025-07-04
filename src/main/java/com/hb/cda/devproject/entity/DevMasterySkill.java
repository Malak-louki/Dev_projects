package com.hb.cda.devproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DevMasterySkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private MasteryLevel masteryLevel;
    @ManyToOne
    private Developer developer;
    @ManyToOne
    private Skill skill;

    public DevMasterySkill() {
    }

    public DevMasterySkill(MasteryLevel masteryLevel, Developer developer, Skill skill) {
        this.masteryLevel = masteryLevel;
        this.developer = developer;
        this.skill = skill;
    }
    public DevMasterySkill(Integer id, MasteryLevel masteryLevel, Developer developer, Skill skill) {
        this.id = id;
        this.masteryLevel = masteryLevel;
        this.developer = developer;
        this.skill = skill;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Developer getDeveloper() {
        return developer;
    }
    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
    public Skill getSkill() {
        return skill;
    }
    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public MasteryLevel getMasteryLevel() {
        return masteryLevel;
    }

    public void setMasteryLevel(MasteryLevel masteryLevel) {
        this.masteryLevel = masteryLevel;
    }
    
    

}
