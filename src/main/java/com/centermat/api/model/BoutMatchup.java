package com.centermat.api.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class BoutMatchup extends BaseModel {
    @ApiModelProperty(required = true, dataType = "UUID")
    @Column(columnDefinition = "BINARY(16)")
    private UUID eventId;
    @Column(columnDefinition = "BINARY(16)")
    private UUID eventMatchupId;
    @Column(columnDefinition = "BINARY(16)")
    private UUID boutId;
    @Column(columnDefinition = "BINARY(16)")
    private UUID wrestlerId;
    @Transient
    private Wrestler wrestler;
    private int score;
    private boolean winner;
    private boolean home;

    @Builder
    public BoutMatchup(UUID id, Wrestler wrestler, int score, boolean winner) {
        super(id);
        this.wrestler = wrestler;
        this.score = score;
        this.winner = winner;
    }
}
