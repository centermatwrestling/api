package com.centermat.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class Event extends BaseModel {

    @Builder
    public Event(UUID id, String name, String logoPath, Date startDate, Date endDate, EventType type) {
        super(id);
        this.name = name;
        this.logoPath = logoPath;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    @JsonProperty(required = true)
    @ApiModelProperty(required = true)
    private String name;
    private String logoPath;
    @JsonProperty(required = true)
    @ApiModelProperty(required = true)
    private Date startDate;
    private Date endDate;
    private EventType type;
}
