package com.centermat.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class TeamMatchup extends BaseModel {
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
