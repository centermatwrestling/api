package com.centermat.api.io.rest;

import com.centermat.api.driver.EventDriver;
import com.centermat.api.driver.EventMatchupDriver;
import com.centermat.api.driver.TeamDriver;
import com.centermat.api.model.Event;
import com.centermat.api.model.EventMatchup;
import com.centermat.api.model.EventType;
import com.centermat.api.model.Team;
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
@RequestMapping(value = "api/v1/teams")
@Api(position = 3, description = "Teams | <a href='http://www.centermatwrestling.com/components/components/cmw-components/'>Web Component</a>")
public class TeamRestController extends AbstractRestController<Team> {
    private final TeamDriver teamDriver;

    @Autowired
    public TeamRestController(TeamDriver teamDriver) {
        super(Team.class, teamDriver);
        this.teamDriver = teamDriver;

    }

    @Override
    public Team getExample() {
        return Team.builder()
                .id(UUID.randomUUID())
                .name("Test Team")
                .abbreviation("TT")
                .shortName("T Team")
                .conferenceId(UUID.randomUUID())
                .levelOfPlayId(UUID.randomUUID())
                .logoPath("http://www.centermatwrestling.com/cdn/images/badge.gif")
                .build();
    }
}
