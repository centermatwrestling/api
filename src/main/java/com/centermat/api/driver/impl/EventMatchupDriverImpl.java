package com.centermat.api.driver.impl;

import com.centermat.api.driver.EventMatchupDriver;
import com.centermat.api.model.EventMatchup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class EventMatchupDriverImpl extends AbstractDriverImpl<EventMatchup> implements EventMatchupDriver {

    @Autowired
    public EventMatchupDriverImpl() {
        super(null);
    }

    @Override
    public List<EventMatchup> fetchByEventId(UUID id) {
        return new LinkedList<>();
    }
}
