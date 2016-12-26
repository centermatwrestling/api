package com.centermat.api.driver.impl;

import com.centermat.api.driver.EventMatchupDriver;
import com.centermat.api.model.EventMatchup;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class EventMatchupDriverImpl extends AbstractDriverImpl<EventMatchup> implements EventMatchupDriver {
    @Override
    public List<EventMatchup> fetchByEventId(UUID id) {
        return new LinkedList<>();
    }
}
