package com.centermat.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Bout extends BaseModel{
    private UUID eventId;
    private UUID eventMatchupId;
    @Transient
    private List<BoutMatchup> boutMatchupList;
    @Transient
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
