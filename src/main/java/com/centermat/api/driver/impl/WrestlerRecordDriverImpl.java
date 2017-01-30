package com.centermat.api.driver.impl;

import com.centermat.api.driver.TeamRecordDriver;
import com.centermat.api.driver.WrestlerRecordDriver;
import com.centermat.api.model.TeamRecord;
import com.centermat.api.model.WrestlerRecord;
import com.centermat.api.repositories.TeamRecordRepository;
import com.centermat.api.repositories.WrestlerRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WrestlerRecordDriverImpl extends AbstractDriverImpl<WrestlerRecord> implements WrestlerRecordDriver{

    @Autowired
    public WrestlerRecordDriverImpl(WrestlerRecordRepository repository) {
        super(repository);
    }
}
