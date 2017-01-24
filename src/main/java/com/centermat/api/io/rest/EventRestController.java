package com.centermat.api.io.rest;

import com.centermat.api.driver.EventDriver;
import com.centermat.api.driver.EventMatchupDriver;
import com.centermat.api.model.Event;
import com.centermat.api.model.EventMatchup;
import com.centermat.api.model.EventType;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(position = 1, description = "Events <a href='http://www.centermatwrestling.com/components/components/cmw-components/'>Web Component</a>")
public class EventRestController extends AbstractRestController<Event> {
    private final EventMatchupDriver eventMatchupDriver;
    private final EventMatchupRestController eventMatchupRestController;

    @Autowired
    public EventRestController(EventDriver driver, EventMatchupDriver eventMatchupDriver, EventMatchupRestController eventMatchupRestController) {
        super(Event.class, driver);
        this.eventMatchupDriver = eventMatchupDriver;
        this.eventMatchupRestController = eventMatchupRestController;
    }

    @ApiOperation(value = "Matchups associated with Event")
    @RequestMapping(value = "{id}/matchups", method = RequestMethod.GET)
    public List<EventMatchup> getMatchups(@PathVariable UUID id) {
        if(id.equals(example_id)) {
            return Lists.newArrayList(eventMatchupRestController.getExample());
        }
        return eventMatchupDriver.fetchByEventId(id);
    }

    @Override
    public Event getExample() {

        final Event event = Event.builder()
                .id(example_id)
                .name("Test Event")
                .startDate(new Date())
                .endDate(new Date())
                .logoPath("http://www.centermatwrestling.com/cdn/images/badge.gif")
                .type(EventType.CLASSIC_TOURNAMENT)
                .build();
        return event;
    }
}
