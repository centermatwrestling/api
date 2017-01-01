package com.centermat.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class EventMatchup extends BaseModel{

    private UUID eventId;
    private List<TeamMatchup> teams;

    @Builder
    public EventMatchup(UUID id, UUID eventId, List<TeamMatchup> teams) {
        super(id);
        this.eventId = eventId;
        this.teams = teams;
    }
}
