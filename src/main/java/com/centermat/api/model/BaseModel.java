package com.centermat.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.UUID;

@AllArgsConstructor
public abstract class BaseModel {
    @JsonProperty(required = true)
    @ApiModelProperty(required = true, dataType = "UUID")
    protected UUID id;
}
