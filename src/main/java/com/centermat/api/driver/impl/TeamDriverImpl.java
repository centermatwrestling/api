package com.centermat.api.driver.impl;

import com.centermat.api.driver.EventDriver;
import com.centermat.api.driver.TeamDriver;
import com.centermat.api.model.Event;
import com.centermat.api.model.Team;
import com.centermat.api.model.Wrestler;
import com.centermat.api.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TeamDriverImpl extends AbstractDriverImpl<Team, TeamRepository> implements TeamDriver{

    private final EventDriver eventDriver;

    @Autowired
    public TeamDriverImpl(TeamRepository repository, EventDriver eventDriver) {
        super(repository);
        this.eventDriver = eventDriver;
    }

    @Override
    public List<Event> fetchSchedule(UUID id, Integer year) {
        return eventDriver.fetchByTeamIdAndYear(id, year);
    }

    @Override
    public List<Wrestler> fetchRoster(UUID id, String year) {
        return new ArrayList<>();
    }

    @Override
    public void putRoster(UUID id, UUID wrestlerId, Wrestler body) {

    }

    @Override
    public void postRoster(UUID id, Wrestler body) {

    }
}
