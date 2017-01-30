package com.centermat.api.io.rest;

import com.centermat.api.driver.TeamRecordDriver;
import com.centermat.api.driver.WrestlerDriver;
import com.centermat.api.model.TeamRecord;
import com.centermat.api.model.Wrestler;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/teamRecords")
@Api(position = 1, tags = {"Team Records"}, description = "<a href='http://www.centermatwrestling.com/components/components/cmw-components/'>Web Component</a>")
public class TeamRecordRestController extends AbstractRestController<TeamRecord> {

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
