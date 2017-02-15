package com.centermat.api.io.rest;

import com.centermat.api.driver.TeamRecordDriver;
import com.centermat.api.model.TeamRecord;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/teams/{parentId}/teamRecords")
@Api(position = 1, tags = {"Team Records"}, description = "<a href='http://www.centermatwrestling.com/components/components/cmw-components/'>Web Component</a>")
public class TeamRecordRestController extends AbstractChildCrudRestController<TeamRecord> {

    @Autowired
    public TeamRecordRestController(TeamRecordDriver driver) {
        super(TeamRecord.class, driver);
    }

    @Override
    public TeamRecord getExample() {
        return TeamRecord.builder()
                .id(UUID.randomUUID())
                .competitionLevelId(UUID.randomUUID())
                .wins(3)
                .loses(2)
                .build();
    }

}
