package com.centermat.api.driver.impl;

import com.centermat.api.driver.CompetitionLevelDriver;
import com.centermat.api.driver.EventDriver;
import com.centermat.api.driver.TeamRecordDriver;
import com.centermat.api.model.CompetitionLevel;
import com.centermat.api.model.Event;
import com.centermat.api.model.TeamRecord;
import com.centermat.api.repositories.CompetitionLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompetitionLevelLevelDriverImpl extends AbstractDriverImpl<CompetitionLevel, CompetitionLevelRepository> implements CompetitionLevelDriver {

    private final EventDriver eventDriver;
    private final TeamRecordDriver teamRecordDriver;

    @Autowired
    public CompetitionLevelLevelDriverImpl(CompetitionLevelRepository repository, EventDriver eventDriver, TeamRecordDriver teamRecordDriver) {
        super(repository);
        this.eventDriver = eventDriver;
        this.teamRecordDriver = teamRecordDriver;
    }

    @Override
    public List<Event> fetchSchedule(UUID id, Integer year, boolean loadAll) {
        return eventDriver.fetchByCompetitionLevelIdAndYear(id, year, loadAll);
    }

    @Override
    public List<TeamRecord> fetchRankings(UUID id, Integer year, boolean loadAll) {
        return teamRecordDriver.fetchByCompetitionLevelAndYear(id, year, loadAll);
    }
}
