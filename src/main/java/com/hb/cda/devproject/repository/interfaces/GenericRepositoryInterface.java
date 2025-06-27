package com.hb.cda.devproject.repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericRepositoryInterface <T> {
List<T> findAll();
    Optional<T> findById(int id);
    boolean persist(T t);
    boolean delete(T t);
    boolean update(T t);

}
