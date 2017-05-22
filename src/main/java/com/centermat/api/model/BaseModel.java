package com.centermat.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class BaseModel {
    protected static final String BASE_LINK = "/api/v1/";

    @Id
    @JsonProperty(required = true)
    @ApiModelProperty(required = true, dataType = "UUID")
    @Column(columnDefinition = "BINARY(16)")
    protected UUID id;
    protected String link;
    protected BaseModel(){}

    public BaseModel(UUID id) {
        this.id = id;
    }

    public String getLink() {
        if(link == null) {
            return BASE_LINK + getUrlName() + "s/" + getId();
        }
        return link;
    }

    protected String getUrlName() {
        return getClass().getSimpleName().toLowerCase();
    }

}
