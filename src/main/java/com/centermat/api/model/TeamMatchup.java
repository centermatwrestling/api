package com.centermat.api.model;

import lombok.Data;

import java.util.UUID;

@Data
public class TeamMatchup extends BaseModel {
    private UUID teamId;
    private boolean home;
    private int score;
    private boolean winner;

    public TeamMatchup(UUID id) {
        super(id);
        this.teamId = id;
    }

    @Override
    public UUID getId() {
        return getTeamId();
    }

    @Override
    protected String getUrlName() {
        return Team.class.getSimpleName().toLowerCase();
    }
}
