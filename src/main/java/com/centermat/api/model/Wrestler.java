package com.centermat.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
public class Wrestler extends BaseModel{
    private Team team;
    private String name;

    @Builder
    public Wrestler(UUID id, Team team, String name) {
        super(id);
        this.team = team;
        this.name = name;
    }
}
