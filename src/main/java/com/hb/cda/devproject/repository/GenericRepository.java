package com.hb.cda.devproject.repository;

import java.util.List;
import java.util.Optional;

import com.hb.cda.devproject.repository.interfaces.GenericRepositoryInterface;

public abstract  class GenericRepository<T> implements GenericRepositoryInterface<T>  {
    
    @Override
    public List<T> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<T> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean persist(T t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(T t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(T t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

}
