package com.centermat.api.driver.impl;

import com.centermat.api.driver.EventDriver;
import com.centermat.api.model.BaseModel;
import com.centermat.api.model.Event;
import com.centermat.api.model.EventMatchup;
import com.centermat.api.model.TeamMatchup;
import com.centermat.api.repositories.EventMatchupRepository;
import com.centermat.api.repositories.EventRepository;
import com.centermat.api.repositories.TeamRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventDriverImpl extends AbstractDriverImpl<Event, EventRepository> implements EventDriver{

    private final TeamRepository teamRepository;
    private final EventMatchupRepository eventMatchupRepository;

    @Autowired
    public EventDriverImpl(EventRepository repository, TeamRepository teamRepository, EventMatchupRepository eventMatchupRepository) {
        super(repository);
        this.teamRepository = teamRepository;
        this.eventMatchupRepository = eventMatchupRepository;
    }

    @Override
    public List<Event> fetchByTeamIdAndYear(UUID id, Integer year) {
        final List<Event> byTeamIdsAndYear = repository.findByTeamIdsAndYear(id, year);
        Collections.sort(byTeamIdsAndYear);
        return byTeamIdsAndYear;
    }

    @Override
    public List<Event> fetchByCompetitionLevelIdAndYear(UUID id, Integer year, boolean loadAll) {
        final List<UUID> ids = teamRepository.findByLevelOfPlayIdOrConferenceId(id,id).stream().map(BaseModel::getId).collect(Collectors.toList());
        final Set<Event> events = repository.findByTeamIdsInAndYear(ids, year);
        if (loadAll){
            for (Event event : events) {
                event.setEventMatchups(eventMatchupRepository.findByEventId(event.getId(), null).getContent());
                for (EventMatchup eventMatchup : event.getEventMatchups()) {
                    for (TeamMatchup teamMatchup : eventMatchup.getTeams()) {
                        teamMatchup.setTeam(teamRepository.findOne(teamMatchup.getTeamId()));
                    }
                }
            }
        }
        final List<Event> byTeamIdsInAndYear = Lists.newArrayList(events);
        Collections.sort(byTeamIdsInAndYear);
        return byTeamIdsInAndYear;
    }
}
