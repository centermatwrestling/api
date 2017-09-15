package com.centermat.api.driver.impl;

import com.centermat.api.driver.EventMatchupDriver;
import com.centermat.api.model.Event;
import com.centermat.api.model.EventMatchup;
import com.centermat.api.model.TeamMatchup;
import com.centermat.api.repositories.EventMatchupRepository;
import com.centermat.api.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class EventMatchupDriverImpl extends AbstractDriverImpl<EventMatchup, EventMatchupRepository> implements EventMatchupDriver {

    private final TeamRepository teamRepository;

    @Autowired
    public EventMatchupDriverImpl(EventMatchupRepository repository, TeamRepository teamRepository) {
        super(repository);
        this.teamRepository = teamRepository;
    }

    @Override
    public List<EventMatchup> fetchByEventId(UUID id) {
        return new LinkedList<>();
    }

    @Override
    public void post(EventMatchup eventMatchup) {
        eventMatchup.setId(UUID.randomUUID());
        eventMatchup.getTeams().forEach(teamMatchup -> {
            teamMatchup.setId(UUID.randomUUID());
            teamMatchup.setEventMatchupId(eventMatchup.getId());
        });
        repository.save(eventMatchup);
    }

    @Override
    public Page<EventMatchup> fetchAll(UUID parentId, Pageable pageable) {
        return repository.findByEventId(parentId, pageable);
    }

    @Override
    protected void loadAll(EventMatchup one) {
        super.loadAll(one);
        for (TeamMatchup teamMatchup : one.getTeams()) {
            teamMatchup.setTeam(teamRepository.findOne(teamMatchup.getTeamId()));
        }
    }
}
