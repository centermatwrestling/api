package com.centermat.api.driver;

import com.centermat.api.model.EventMatchup;
import com.centermat.api.repositories.EventMatchupRepository;

import java.util.List;
import java.util.UUID;

public interface EventMatchupDriver extends AbstractChildDriver<EventMatchup, EventMatchupRepository> {
    List<EventMatchup> fetchByEventId(UUID id);
}
