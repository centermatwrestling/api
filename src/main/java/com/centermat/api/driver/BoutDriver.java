package com.centermat.api.driver;

import com.centermat.api.model.Bout;
import com.centermat.api.model.Event;
import com.centermat.api.repositories.BoutRepository;

public interface BoutDriver extends AbstractDualChildDriver<Bout, BoutRepository> {
}
