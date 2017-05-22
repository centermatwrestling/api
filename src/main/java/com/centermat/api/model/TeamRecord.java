package com.centermat.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class TeamRecord extends BaseModel {
    @ApiModelProperty(required = true, dataType = "UUID")
    @Column(columnDefinition = "BINARY(16)")
    private UUID teamId;
    @ApiModelProperty(required = true, dataType = "UUID")
    @Column(columnDefinition = "BINARY(16)")
    private UUID competitionLevelId;
    private Integer year;
    private Integer wins;
    private Integer loses;

    @Builder
    public TeamRecord(UUID id, UUID teamId, UUID competitionLevelId, Integer year, Integer wins, Integer loses) {
        this.id = id;
        this.teamId = teamId;
        this.competitionLevelId = competitionLevelId;
        this.year = year;
        this.wins = wins;
        this.loses = loses;
    }

}
