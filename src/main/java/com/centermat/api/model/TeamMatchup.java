package com.centermat.api.model;

import lombok.Data;

import java.util.UUID;

@Data
public class TeamMatchup extends BaseModel {
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
