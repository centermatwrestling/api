package com.centermat.api.driver.impl;

import com.centermat.api.driver.BoutDriver;
import com.centermat.api.driver.EventDriver;
import com.centermat.api.model.Bout;
import com.centermat.api.model.Event;
import com.centermat.api.repositories.BoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoutDriverImpl extends AbstractDriverImpl<Bout> implements BoutDriver{

    @Autowired
    public BoutDriverImpl(BoutRepository repository) {
        super(repository);
    }
}
