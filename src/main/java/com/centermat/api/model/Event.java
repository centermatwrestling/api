package com.centermat.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Event extends BaseModel {

    @Builder
    public Event(UUID id, String name, String logoPath, Date startDate, Date endDate, EventType type, String matchupsLink) {
        super(id);
        this.name = name;
        this.logoPath = logoPath;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.matchupsLink = matchupsLink;
    }

    @JsonProperty(required = true)
    @ApiModelProperty(required = true)
    private String name;
    @Column(name = "logo_path")
    private String logoPath;
    private Integer year;
    @JsonProperty(required = true)
    @ApiModelProperty(required = true)
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private EventType type;
    @ElementCollection
    private Collection<UUID> teamIds;
    @Transient
    private String matchupsLink;

    public String getMatchupsLink() {
        if(matchupsLink == null) {
            return getLink() + "/matchups";
        }
        return matchupsLink;
    }

}
