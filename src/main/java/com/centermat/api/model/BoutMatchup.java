package com.centermat.api.model;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
public class BoutMatchup extends BaseModel {
    private Wrestler wrestler;
    private int score;
    private boolean winner;

    @Builder
    public BoutMatchup(UUID id, Wrestler wrestler, int score, boolean winner) {
        super(id);
        this.wrestler = wrestler;
        this.score = score;
        this.winner = winner;
    }
}
