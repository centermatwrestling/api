package com.centermat.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Data
public class Event extends BaseModel {
    @JsonProperty(required = true)
    @ApiModelProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    @ApiModelProperty(required = true)
    private Date startDate;
    @JsonProperty(required = false)
    private Date endDate;
    private EventType type;
}
