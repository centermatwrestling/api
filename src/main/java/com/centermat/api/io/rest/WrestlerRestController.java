package com.centermat.api.io.rest;

import com.centermat.api.driver.WrestlerDriver;
import com.centermat.api.model.Wrestler;
import com.centermat.api.repositories.WrestlerRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/wrestlers")
@Api(position = 1, tags = {"Wrestlers"},description = "<a href='http://www.centermatwrestling.com/components/components/cmw-components/'>Web Component</a>")
public class WrestlerRestController extends AbstractCrudRestController<Wrestler, WrestlerRepository, WrestlerDriver> {

    @Autowired
    public WrestlerRestController(WrestlerDriver driver) {
        super(Wrestler.class, driver);
    }

    @Override
    public Wrestler getExample() {
        return Wrestler.builder()
                .id(UUID.randomUUID())
                .firstName("First")
                .lastName("Last")
                .build();
    }
}
