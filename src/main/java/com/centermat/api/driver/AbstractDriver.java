package com.centermat.api.driver;

import com.centermat.api.model.BaseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AbstractDriver<T extends BaseModel, R extends JpaRepository<T, UUID>> {

    Page<T> fetchAll(Pageable pageable);

    T findOne(UUID id, boolean loadAll);

    void delete(UUID id);

    void post(T t);

    void put(UUID id, T t);
}
