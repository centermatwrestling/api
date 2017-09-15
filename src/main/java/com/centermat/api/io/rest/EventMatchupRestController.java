package com.centermat.api.io.rest;

import com.centermat.api.driver.EventMatchupDriver;
import com.centermat.api.model.*;
import com.centermat.api.repositories.EventMatchupRepository;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/events/{parentId}/eventMatchups")
@Api(position = 2, tags = {"Event Matchups"},description = "<a href='http://www.centermatwrestling.com/components/components/cmw-components/'>Web Component</a>")
public class EventMatchupRestController extends AbstractChildCrudRestController<EventMatchup, EventMatchupRepository, EventMatchupDriver> {

    private final TeamRestController teamRestController;

    @Autowired
    public EventMatchupRestController(EventMatchupDriver driver, TeamRestController teamRestController) {
        super(EventMatchup.class, driver);
        this.teamRestController = teamRestController;
    }

    @Override
    public EventMatchup getExample() {
        return EventMatchup.builder()
                .id(UUID.randomUUID())
                .teams(Lists.newArrayList(
                        new TeamMatchup(Team.builder().id(UUID.randomUUID()).name("Test team1").build()),
                        new TeamMatchup(Team.builder().id(UUID.randomUUID()).name("Test team1").build())))
                .build();
    }

}
