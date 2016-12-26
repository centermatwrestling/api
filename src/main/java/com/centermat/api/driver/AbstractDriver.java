package com.centermat.api.driver;

import com.centermat.api.model.Event;

import java.util.List;
import java.util.UUID;

public interface AbstractDriver<T> {
    List<T> fetchAll();

    T findOne(UUID id);
}
