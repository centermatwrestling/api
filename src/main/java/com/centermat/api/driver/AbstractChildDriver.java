package com.centermat.api.driver;

import com.centermat.api.model.BaseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AbstractChildDriver<T extends BaseModel, R extends JpaRepository<T, UUID>> extends AbstractDriver<T, R> {

    Page<T> fetchAll(UUID parentId, Pageable pageable);
}
