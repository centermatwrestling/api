package com.centermat.api.driver.impl;

import com.centermat.api.driver.CompetitionLevelDriver;
import com.centermat.api.model.CompetitionLevel;
import com.centermat.api.model.Event;
import com.centermat.api.repositories.CompetitionLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionLevelLevelDriverImpl extends AbstractDriverImpl<CompetitionLevel> implements CompetitionLevelDriver {

    @Autowired
    public CompetitionLevelLevelDriverImpl(CompetitionLevelRepository repository) {
        super(repository);
    }
}
