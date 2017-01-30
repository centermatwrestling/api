package com.centermat.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class WrestlerRecord extends BaseModel{

    private UUID wrestlerId;
    private UUID competitionLevelId;
    @Convert(converter = JpaConverterJson.class)
    private WeightClass weightClass;
    private Integer year;
    private Integer wins;
    private Integer loses;
    @Convert(converter = JpaConverterJson.class)
    private Map<WinType,Integer> winTypeCounts;

    @Builder
    public WrestlerRecord(UUID id, UUID wrestlerId, UUID competitionLevelId, WeightClass weightClass, Integer year, Integer wins, Integer loses, Map<WinType,Integer> winTypeCounts) {
        super(id);
        this.wrestlerId = wrestlerId;
        this.competitionLevelId = competitionLevelId;
        this.weightClass = weightClass;
        this.year = year;
        this.wins = wins;
        this.loses = loses;
        this.winTypeCounts = winTypeCounts;
    }
}
