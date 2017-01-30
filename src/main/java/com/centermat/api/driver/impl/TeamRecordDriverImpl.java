package com.centermat.api.driver.impl;

import com.centermat.api.driver.TeamRecordDriver;
import com.centermat.api.driver.WrestlerDriver;
import com.centermat.api.model.TeamRecord;
import com.centermat.api.model.Wrestler;
import com.centermat.api.repositories.TeamRecordRepository;
import com.centermat.api.repositories.WrestlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamRecordDriverImpl extends AbstractDriverImpl<TeamRecord> implements TeamRecordDriver{

    @Autowired
    public TeamRecordDriverImpl(TeamRecordRepository repository) {
        super(repository);
    }
}
