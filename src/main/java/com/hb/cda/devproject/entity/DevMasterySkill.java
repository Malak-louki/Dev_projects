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
    private Mastery mastery;
    @ManyToOne
    private Developer developer;
    @ManyToOne
    private Skill skill;
    public DevMasterySkill() {
    }
    public DevMasterySkill(Mastery mastery, Developer developer, Skill skill) {
        this.mastery = mastery;
        this.developer = developer;
        this.skill = skill;
    }
    public DevMasterySkill(Integer id, Mastery mastery, Developer developer, Skill skill) {
        this.id = id;
        this.mastery = mastery;
        this.developer = developer;
        this.skill = skill;
    }
      public Integer getId() {
          return id;
      }
      public void setId(Integer id) {
          this.id = id;
      }
      public Mastery getMastery() {
          return mastery;
      }
      public void setMastery(Mastery mastery) {
          this.mastery = mastery;
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
    
    

}
