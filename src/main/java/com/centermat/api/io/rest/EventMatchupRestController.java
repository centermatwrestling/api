package com.centermat.api.io.rest;

import com.centermat.api.driver.EventDriver;
import com.centermat.api.driver.EventMatchupDriver;
import com.centermat.api.model.Event;
import com.centermat.api.model.EventMatchup;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/eventMatchups")
@Api(position = 2, description = "Event Matchup <a href='http://www.centermatwrestling.com/components/components/cmw-components/'>Web Component</a>")
public class EventMatchupRestController extends AbstractRestController<EventMatchup> {

    @Autowired
    public EventMatchupRestController(EventMatchupDriver driver) {
        super(EventMatchup.class, driver);

    }

    @Override
    public EventMatchup getExample() {
        return EventMatchup.builder().build();
    }
}
