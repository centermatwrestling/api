package com.centermat.api.model;

import lombok.Builder;

import java.util.UUID;

public class EventMatchup extends BaseModel{

    @Builder
    public EventMatchup(UUID id) {
        super(id);
    }
}
