package com.centermat.api.driver.impl;

import com.centermat.api.driver.TeamRecordDriver;
import com.centermat.api.driver.WrestlerDriver;
import com.centermat.api.model.Event;
import com.centermat.api.model.TeamRecord;
import com.centermat.api.model.Wrestler;
import com.centermat.api.repositories.TeamRecordRepository;
import com.centermat.api.repositories.TeamRepository;
import com.centermat.api.repositories.WrestlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeamRecordDriverImpl extends AbstractDriverImpl<TeamRecord, TeamRecordRepository> implements TeamRecordDriver{

    @Autowired
    public TeamRecordDriverImpl(TeamRecordRepository repository) {
        super(repository);
    }

    @Override
    public Page<TeamRecord> fetchAll(UUID parentId, Pageable pageable) {
        return repository.findByTeamId(parentId, pageable);
    }

    @Override
    public List<TeamRecord> fetchByCompetitionLevelAndYear(UUID id, Integer year, boolean loadAll) {
        return repository.findByTeamIdInAndYear(id, year);
    }
}
