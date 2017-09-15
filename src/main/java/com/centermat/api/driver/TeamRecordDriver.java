package com.centermat.api.driver;

import com.centermat.api.model.Event;
import com.centermat.api.model.TeamRecord;
import com.centermat.api.model.Wrestler;
import com.centermat.api.repositories.TeamRecordRepository;

import java.util.List;
import java.util.UUID;

public interface TeamRecordDriver extends AbstractChildDriver<TeamRecord, TeamRecordRepository> {
    List<TeamRecord> fetchByCompetitionLevelAndYear(UUID id, Integer year, boolean loadAll);
}
