package com.hb.cda.devproject.repository.interfaces;

import java.util.Optional;

import com.hb.cda.devproject.entity.Developer;

public interface DeveloperRepository extends  GenericRepositoryInterface<Developer> {
public Optional<Developer> getByUserName(String username);

}
