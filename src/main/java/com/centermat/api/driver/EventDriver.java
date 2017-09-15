package com.centermat.api.driver;

import com.centermat.api.model.Event;
import com.centermat.api.repositories.EventRepository;

import java.util.List;
import java.util.UUID;

public interface EventDriver extends AbstractDriver<Event, EventRepository> {
    List<Event> fetchByTeamIdAndYear(UUID id, Integer year);

    List<Event> fetchByCompetitionLevelIdAndYear(UUID id, Integer year, boolean loadAll);
}
