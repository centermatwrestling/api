package com.centermat.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public abstract class BaseModel {
    protected static final String BASE_LINK = "/api/v1/";

    @JsonProperty(required = true)
    @ApiModelProperty(required = true, dataType = "UUID")
    protected UUID id;

    public String getLink() {
        return BASE_LINK + getUrlName() + "s/" + getId();
    }

    protected String getUrlName() {
        return getClass().getSimpleName().toLowerCase();
    }

    ;
}
