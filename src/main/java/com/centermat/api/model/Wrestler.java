package com.centermat.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Wrestler extends BaseModel{
    @Column(columnDefinition = "BINARY(16)")
    private UUID teamId;
    @Transient
    private Team team;
    private String firstName;
    private String lastName;

    @Builder
    public Wrestler(UUID id, Team team, String firstName, String lastName, UUID teamId) {
        super(id);
        this.team = team;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamId = teamId;
    }
}
