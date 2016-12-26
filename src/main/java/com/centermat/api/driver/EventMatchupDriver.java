package com.centermat.api.driver;

import com.centermat.api.model.EventMatchup;

import java.util.List;
import java.util.UUID;

public interface EventMatchupDriver extends AbstractDriver<EventMatchup> {
    List<EventMatchup> fetchByEventId(UUID id);
}
