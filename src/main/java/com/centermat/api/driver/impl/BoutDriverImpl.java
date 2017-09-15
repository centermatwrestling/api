package com.centermat.api.driver.impl;

import com.centermat.api.driver.BoutDriver;
import com.centermat.api.driver.EventDriver;
import com.centermat.api.model.Bout;
import com.centermat.api.model.Event;
import com.centermat.api.model.EventMatchup;
import com.centermat.api.repositories.BoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BoutDriverImpl extends AbstractDriverImpl<Bout, BoutRepository> implements BoutDriver{

    @Autowired
    public BoutDriverImpl(BoutRepository repository) {
        super(repository);
    }

    @Override
    public void post(Bout bout) {
        bout.setId(UUID.randomUUID());
        bout.getBoutMatchupList().forEach(boutMatchup -> {
            boutMatchup.setId(UUID.randomUUID());
            boutMatchup.setBoutId(bout.getId());
            boutMatchup.setEventMatchupId(bout.getEventMatchupId());
        });
        repository.save(bout);
    }

    @Override
    public Page<Bout> fetchAll(UUID parentId, UUID parent2Id, Pageable pageable) {
        return repository.findByEventIdAndEventMatchupId(parentId, parent2Id, pageable);
    }
}
