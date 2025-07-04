package com.hb.cda.devproject.repository.interfaces;

import java.util.Optional;

import com.hb.cda.devproject.entity.ProjectOwner;

public interface ProjectOwnerRepository extends  GenericRepositoryInterface<ProjectOwner> {
public Optional<ProjectOwner> getByUserName(String username);
}
