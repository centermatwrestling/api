package com.centermat.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CompetitionLevel extends BaseModel{

    private String name;
    @Column(name = "logo_path")
    private String logoPath;
    private Integer tier;
    @Column(name = "parent_tier")
    private UUID parentTier;

    @Builder
    public CompetitionLevel(UUID id,String name, String logoPath) {
        super(id);
        this.name = name;
        this.logoPath = logoPath;
    }
}
