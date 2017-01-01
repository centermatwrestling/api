package com.centermat.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class Team extends BaseModel{

    private String name;
    private String logoPath;
    private String shortName;
    private String abbreviation;
    private UUID conferenceId;
    private UUID levelOfPlayId;

    @Builder
    public Team(UUID id, String name, String logoPath, String shortName, String abbreviation, UUID conferenceId, UUID levelOfPlayId) {
        super(id);
        this.name = name;
        this.logoPath = logoPath;
        this.shortName = shortName;
        this.abbreviation = abbreviation;
        this.conferenceId = conferenceId;
        this.levelOfPlayId = levelOfPlayId;
    }
}
