package com.hb.cda.devproject.repository.interfaces;

import java.util.Optional;

import com.hb.cda.devproject.entity.Skill;

public interface SkillRepository extends  GenericRepositoryInterface<Skill>{
Optional<Skill> findByName(String name);
}
