package com.centermat.api.driver.impl;

import com.centermat.api.driver.EventMatchupDriver;
import com.centermat.api.model.EventMatchup;
import com.centermat.api.model.TeamMatchup;
import com.centermat.api.repositories.EventMatchupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

@Service
public class EventMatchupDriverImpl extends AbstractDriverImpl<EventMatchup> implements EventMatchupDriver {

    @Autowired
    public EventMatchupDriverImpl(EventMatchupRepository repository) {
        super(repository);
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
}
