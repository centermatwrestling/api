package com.centermat.api.io.rest;

import com.centermat.api.driver.CompetitionLevelDriver;
import com.centermat.api.model.CompetitionLevel;
import com.centermat.api.model.Event;
import com.centermat.api.model.TeamRecord;
import com.centermat.api.repositories.CompetitionLevelRepository;
import com.google.common.base.Preconditions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/competitionLevels")
@Api(position = 1,tags = {"Competition Levels"}, description = "<a href='http://www.centermatwrestling.com/components/components/cmw-components/'>Web Component</a>")
public class CompetitionLevelRestController extends AbstractCrudRestController<CompetitionLevel, CompetitionLevelRepository, CompetitionLevelDriver> {


    @Autowired
    public CompetitionLevelRestController(CompetitionLevelDriver driver) {
        super(CompetitionLevel.class, driver);
    }

    @ApiOperation(value = "Schedule of Competition Level")
    @RequestMapping(value = "/{id}/schedule/{year}", method = RequestMethod.GET)
    public List<Event> getSchedule(@PathVariable UUID id, @PathVariable String year, @RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "100") Integer size, @RequestParam(required = false) String fields, @RequestParam(required = false) boolean loadAll) throws IOException {
        Preconditions.checkArgument(year.matches("\\d{4}|latest"),"Year should be a valid year");
        return driver.fetchSchedule(id, Integer.parseInt(year),loadAll);
    }

    @ApiOperation(value = "Single instance of type")
    @RequestMapping(value = "/{id}/rankings/{year}", method = RequestMethod.GET)
    public List<TeamRecord> getRankings(@PathVariable UUID id, @PathVariable String year, @RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "100") Integer size, @RequestParam(required = false) String fields, @RequestParam(required = false) boolean loadAll) throws IOException {
        Preconditions.checkArgument(year.matches("\\d{4}|latest"),"Year should be a valid year");
        return driver.fetchRankings(id, Integer.parseInt(year),loadAll);
    }

    @Override
    public CompetitionLevel getExample() {
        return CompetitionLevel.builder()
                .id(UUID.randomUUID())
                .name("College")
                .logoPath("http://path")
                .build();
    }
}
