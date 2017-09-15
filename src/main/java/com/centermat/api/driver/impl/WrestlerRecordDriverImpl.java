package com.centermat.api.driver.impl;

import com.centermat.api.driver.WrestlerRecordDriver;
import com.centermat.api.model.WrestlerRecord;
import com.centermat.api.repositories.WrestlerRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WrestlerRecordDriverImpl extends AbstractDriverImpl<WrestlerRecord, WrestlerRecordRepository> implements WrestlerRecordDriver{

    @Autowired
    public WrestlerRecordDriverImpl(WrestlerRecordRepository repository) {
        super(repository);
    }

    @Override
    public Page<WrestlerRecord> fetchAll(UUID parentId, Pageable pageable) {
        return repository.findByWrestlerId(parentId, pageable);
    }
}
