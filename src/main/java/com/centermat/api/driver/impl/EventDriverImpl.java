package com.centermat.api.driver.impl;

import com.centermat.api.driver.EventDriver;
import com.centermat.api.model.Event;
import com.centermat.api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventDriverImpl extends AbstractDriverImpl<Event> implements EventDriver{

    @Autowired
    public EventDriverImpl(EventRepository repository) {
        super(repository);
    }
}
