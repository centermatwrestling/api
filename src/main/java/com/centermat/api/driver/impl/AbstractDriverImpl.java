package com.centermat.api.driver.impl;

import com.centermat.api.driver.AbstractDriver;
import com.centermat.api.model.BaseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public abstract class AbstractDriverImpl<T extends BaseModel> implements AbstractDriver<T>{

    protected JpaRepository<T,UUID> repository;

    public AbstractDriverImpl(JpaRepository<T, UUID> repository) {
        this.repository = repository;
    }

    @Override
    public Page<T> fetchAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public T findOne(UUID id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(id);
    }

    @Override
    public void put(UUID id, T t) {
        repository.save(t);
    }

    @Override
    public void post(T t) {
        t.setId(UUID.randomUUID());
        repository.save(t);
    }
}
