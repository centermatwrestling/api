package com.centermat.api.io.rest;

import com.centermat.api.driver.TeamDriver;
import com.centermat.api.model.Event;
import com.centermat.api.model.Team;
import com.centermat.api.model.Wrestler;
import com.centermat.api.repositories.TeamRepository;
import com.google.common.base.Preconditions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/teams")
@Api(position = 2,  tags = {"Teams"}, description = "<a href='http://www.centermatwrestling.com/components/components/cmw-components/'>Web Component</a>")
public class TeamRestController extends AbstractCrudRestController<Team, TeamRepository, TeamDriver> {
    public static final String YEAR_NOTES = "Year param must be a valid 4 digit date. ie 2016-2017 would be 2017. latest as year value will return latest defined season";
    private final TeamDriver teamDriver;

    @Autowired
    public TeamRestController(TeamDriver teamDriver) {
        super(Team.class, teamDriver);
        this.teamDriver = teamDriver;

    }

    @ApiOperation(value = "Returns schedule for provided team", notes = YEAR_NOTES)
    @RequestMapping(method = RequestMethod.GET, value = "{id}/schedule/{year}")
    public List<Event> schedule(@PathVariable UUID id, @PathVariable String year) {
        Preconditions.checkArgument(year.matches("\\d{4}|latest"),"Year should be a valid year");
        final List<Event> events = teamDriver.fetchSchedule(id, Integer.parseInt(year));
        return events;
    }

    @ApiOperation(value = "Returns roster for provided team", notes = YEAR_NOTES)
    @RequestMapping(method = RequestMethod.GET, value = "{id}/roster/{year}")
    public List<Wrestler> roster(@PathVariable UUID id, @PathVariable String year) {
        Preconditions.checkArgument(year.matches("\\d{4}|latest"),"Year should be a valid year");
        return teamDriver.fetchRoster(id, year);
    }

    @ApiOperation(value = "Create instance of type")
    @RequestMapping(value = "{id}/roster/{wrestlerId}", method = RequestMethod.PUT)
    public void putRoster(@PathVariable UUID id, @PathVariable UUID wrestlerId, @RequestBody Wrestler body, @RequestHeader(name = "Authorization") String jwtToken) {
        teamDriver.putRoster(id, wrestlerId, body);
    }

    @ApiOperation(value = "Update instance of type")
    @RequestMapping(value = "{id}/roster", method = RequestMethod.POST)
    public void postRoster(@PathVariable UUID id, @RequestBody Wrestler body, @RequestHeader(name = "Authorization") String jwtToken) {
        teamDriver.postRoster(id,body);
    }

    @Override
    public Team getExample() {
        return Team.builder()
                .id(UUID.randomUUID())
                .name("Test Team")
                .abbr("TT")
                .shortName("T Team")
                .conferenceId(UUID.randomUUID())
                .levelOfPlayId(UUID.randomUUID())
                .logoPath("http://www.centermatwrestling.com/cdn/images/badge.gif")
                .build();
    }
}
