package com.centermat.api.io.rest;

import com.centermat.api.driver.EventDriver;
import com.centermat.api.driver.EventMatchupDriver;
import com.centermat.api.model.Event;
import com.centermat.api.model.EventMatchup;
import com.centermat.api.model.EventType;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/events")
@Api(value = "Events", description = "Events")
public class EventRestController extends AbstractRestController<Event> {
    private final EventMatchupDriver eventMatchupDriver;

    @Autowired
    public EventRestController(EventDriver driver,EventMatchupDriver eventMatchupDriver) {
        super(Event.class, driver);
        this.eventMatchupDriver = eventMatchupDriver;

    }

    @RequestMapping(value = "{id}/matchups", method = RequestMethod.GET)
    public List<EventMatchup> getMatchups(@PathVariable UUID id) {
        return eventMatchupDriver.fetchByEventId(id);
    }

    @Override
    public Event getExample() {
        final Event event = Event.builder()
                .id(UUID.randomUUID())
                .name("Test Event")
                .startDate(new Date())
                .endDate(new Date())
                .logoPath("http://www.centermatwrestling.com/cdn/images/badge.gif")
                .type(EventType.CLASSIC_TOURNAMENT)
                .build();
        return event;
    }
}
