package com.centermat.api.io.rest;

import com.centermat.api.driver.BoutDriver;
import com.centermat.api.model.Bout;
import com.centermat.api.repositories.BoutRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/events/{parentId}/eventMatchups/{parent2Id}/bouts")
@Api(position = 1,tags = {"Bouts"}, description = "<a href='http://www.centermatwrestling.com/components/components/cmw-components/'>Web Component</a>")
public class BoutRestController extends AbstractDualChileCrudRestController<Bout, BoutRepository, BoutDriver> {

    @Autowired
    public BoutRestController(BoutDriver driver) {
        super(Bout.class, driver);
    }

    @Override
    public Bout getExample() {
        return Bout.builder()
                .id(UUID.randomUUID())
                .build();
    }
}
