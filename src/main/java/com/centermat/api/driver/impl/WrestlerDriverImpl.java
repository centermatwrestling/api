package com.centermat.api.driver.impl;

import com.centermat.api.driver.EventDriver;
import com.centermat.api.driver.WrestlerDriver;
import com.centermat.api.model.Event;
import com.centermat.api.model.Wrestler;
import com.centermat.api.repositories.WrestlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WrestlerDriverImpl extends AbstractDriverImpl<Wrestler, WrestlerRepository> implements WrestlerDriver{

    @Autowired
    public WrestlerDriverImpl(WrestlerRepository repository) {
        super(repository);
    }
}
