package com.centermat.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class TeamMatchup extends BaseModel {
    @ApiModelProperty(required = true, dataType = "UUID")
    @Column(columnDefinition = "BINARY(16)")
    private UUID eventMatchupId;
    @Column(columnDefinition = "BINARY(16)")
    private UUID teamId;
    @Transient
    private Team team;
    private boolean home;
    private int score;
    private boolean winner;

    public TeamMatchup(Team team) {
        super(team.getId());
    }

    @Override
    protected String getUrlName() {
        return Team.class.getSimpleName().toLowerCase();
    }
}
