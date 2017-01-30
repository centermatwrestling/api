package com.centermat.api.driver;

import com.centermat.api.model.Event;
import com.centermat.api.model.Team;
import com.centermat.api.model.Wrestler;

import java.util.List;
import java.util.UUID;

public interface TeamDriver extends AbstractDriver<Team> {
    List<Event> fetchSchedule(UUID id, String year);

    List<Wrestler> fetchRoster(UUID id, String year);

    void putRoster(UUID id, UUID wrestlerId, Wrestler body);

    void postRoster(UUID id, Wrestler body);
}
