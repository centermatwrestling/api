package com.centermat.api.io.rest;

import com.centermat.api.driver.CompetitionLevelDriver;
import com.centermat.api.model.CompetitionLevel;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/competitionLevels")
@Api(position = 1,tags = {"Competition Levels"}, description = "<a href='http://www.centermatwrestling.com/components/components/cmw-components/'>Web Component</a>")
public class CompetitionLevelRestController extends AbstractCrudRestController<CompetitionLevel> {

    @Autowired
    public CompetitionLevelRestController(CompetitionLevelDriver driver) {
        super(CompetitionLevel.class, driver);
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
