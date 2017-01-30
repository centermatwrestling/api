package com.centermat.api.driver;

import com.centermat.api.model.BaseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AbstractDriver<T extends BaseModel> {

    Page<T> fetchAll(Pageable pageable);

    T findOne(UUID id);

    void delete(UUID id);

    void post(T t);

    void put(UUID id, T t);
}
