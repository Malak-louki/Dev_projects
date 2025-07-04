package com.hb.cda.devproject.repository.interfaces;

import java.util.Optional;

import com.hb.cda.devproject.entity.User;

public interface UserRepository extends  GenericRepositoryInterface<User> {

Optional<User> findByEmail(String email);

Optional<User> findByUsername(String username);
}
