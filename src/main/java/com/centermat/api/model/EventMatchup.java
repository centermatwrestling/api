package com.centermat.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class EventMatchup extends BaseModel {
    @Column(columnDefinition = "BINARY(16)")
    private UUID eventId;
    private String name;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "eventMatchupId")
    private List<TeamMatchup> teams;
    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @Builder
    public EventMatchup(UUID id, UUID eventId, List<TeamMatchup> teams) {
        super(id);
        this.eventId = eventId;
        this.teams = teams;
    }
}
