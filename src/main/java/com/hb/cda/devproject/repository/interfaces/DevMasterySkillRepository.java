package com.hb.cda.devproject.repository.interfaces;

import java.util.List;

import com.hb.cda.devproject.entity.DevMasterySkill;
import com.hb.cda.devproject.entity.MasteryLevel;

public interface DevMasterySkillRepository extends GenericRepositoryInterface<DevMasterySkill>{
// Compétences d'un développeur
List<DevMasterySkill> findByDeveloperId(Integer developerId);

// Développeurs ayant une compétence spécifique
List<DevMasterySkill> findBySkillId(Integer skillId);

// Développeurs par compétence et niveau
List<DevMasterySkill> findBySkillIdAndMasteryLevel(Integer skillId, MasteryLevel level);
}
