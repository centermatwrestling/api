package com.centermat.api.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Team extends BaseModel{

    private String name;
    @Column( name = "logo_path")
    private String logoPath;
    @Column(name = "short_name")
    private String shortName;
    private String abbr;
    @Column(name = "conference_id")
    private UUID conferenceId;
    @Column(name = "level_of_play_id")
    private UUID levelOfPlayId;
    @Column(name = "primary_color")
    private String primaryColor;
    @Column(name = "secondary_color")
    private String secondaryColor;


    @Builder
    public Team(UUID id, String name, String logoPath, String shortName, String abbr, UUID conferenceId, UUID levelOfPlayId) {
        super(id);
        this.name = name;
        this.logoPath = logoPath;
        this.shortName = shortName;
        this.abbr = abbr;
        this.conferenceId = conferenceId;
        this.levelOfPlayId = levelOfPlayId;
    }
}
