package com.centermat.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Bout extends BaseModel{
    @Column(columnDefinition = "BINARY(16)")
    private UUID eventId;
    @Column(columnDefinition = "BINARY(16)")
    private UUID eventMatchupId;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "boutId")
    private List<BoutMatchup> boutMatchupList;
    @Convert(converter = JpaConverterJson.class)
    private WeightClass weightClass;
    @Enumerated(EnumType.STRING)
    private WinType winType;

    @Builder
    public Bout(UUID id, UUID eventId, UUID eventMatchupId, List<BoutMatchup> boutMatchupList, WeightClass weightClass) {
        super(id);
        this.eventId = eventId;
        this.eventMatchupId = eventMatchupId;
        this.boutMatchupList = boutMatchupList;
        this.weightClass = weightClass;
    }
}
