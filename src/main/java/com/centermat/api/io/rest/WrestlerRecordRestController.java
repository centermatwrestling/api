package com.centermat.api.io.rest;

import com.centermat.api.driver.WrestlerRecordDriver;
import com.centermat.api.model.WrestlerRecord;
import com.centermat.api.repositories.WrestlerRecordRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/wrestlers/{parentId}/wrestlerRecords")
@Api(position = 1,tags = {"Wrestler Records"}, description = "<a href='http://www.centermatwrestling.com/components/components/cmw-components/'>Web Component</a>")
public class WrestlerRecordRestController extends AbstractChildCrudRestController<WrestlerRecord, WrestlerRecordRepository, WrestlerRecordDriver> {

    @Autowired
    public WrestlerRecordRestController(WrestlerRecordDriver driver) {
        super(WrestlerRecord.class, driver);
    }

    @Override
    public WrestlerRecord getExample() {
        return WrestlerRecord.builder()
                .id(UUID.randomUUID())
                .competitionLevelId(UUID.randomUUID())
                .wins(3)
                .loses(2)
                .build();
    }
}
