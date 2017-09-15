package com.centermat.api.driver.impl;

import com.centermat.api.driver.AbstractDriver;
import com.centermat.api.model.BaseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collections;
import java.util.UUID;

public abstract class AbstractDriverImpl<T extends BaseModel, R extends JpaRepository<T, UUID>> implements AbstractDriver<T, R>{

    protected R repository;

    public AbstractDriverImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public Page<T> fetchAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public T findOne(UUID id, boolean loadAll) {
        final T one = repository.findOne(id);
        if(loadAll) {
            loadAll(one);
        }
        return one;
    }

    protected void loadAll(T one){};

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
