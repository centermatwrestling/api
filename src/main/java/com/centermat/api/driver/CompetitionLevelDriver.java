package com.centermat.api.driver;

import com.centermat.api.model.CompetitionLevel;
import com.centermat.api.model.Event;
import com.centermat.api.model.TeamRecord;
import com.centermat.api.repositories.CompetitionLevelRepository;

import java.util.List;
import java.util.UUID;

public interface CompetitionLevelDriver extends AbstractDriver<CompetitionLevel, CompetitionLevelRepository> {
    List<Event> fetchSchedule(UUID id, Integer year, boolean loadAll);

    List<TeamRecord> fetchRankings(UUID id, Integer year, boolean loadAll);
}
