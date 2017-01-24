package com.centermat.api.driver.impl;

import com.centermat.api.driver.AbstractDriver;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractDriverImpl<T> implements AbstractDriver<T>{
    @Override
    public List<T> fetchAll() {
        return new LinkedList<>();
    }

    @Override
    public T findOne(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public void post(UUID id, T t) {

    }

    @Override
    public void put(T t) {

    }
}
