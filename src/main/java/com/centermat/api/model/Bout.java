package com.centermat.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Bout extends BaseModel{
    private UUID eventId;
    private UUID eventMatchupId;
    private List<BoutMatchup> boutMatchupList;
    private WeightClass weightClass;

    @Builder
    public Bout(UUID id, UUID eventId, UUID eventMatchupId, List<BoutMatchup> boutMatchupList, WeightClass weightClass) {
        super(id);
        this.eventId = eventId;
        this.eventMatchupId = eventMatchupId;
        this.boutMatchupList = boutMatchupList;
        this.weightClass = weightClass;
    }
}
