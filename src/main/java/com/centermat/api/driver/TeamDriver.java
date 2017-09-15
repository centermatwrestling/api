package com.centermat.api.driver;

import com.centermat.api.model.Event;
import com.centermat.api.model.Team;
import com.centermat.api.model.Wrestler;
import com.centermat.api.repositories.TeamRepository;

import java.util.List;
import java.util.UUID;

public interface TeamDriver extends AbstractDriver<Team, TeamRepository> {
    List<Event> fetchSchedule(UUID id, Integer year);

    List<Wrestler> fetchRoster(UUID id, String year);

    void putRoster(UUID id, UUID wrestlerId, Wrestler body);

    void postRoster(UUID id, Wrestler body);
}
