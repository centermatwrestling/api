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
public class CompetitionLevel extends BaseModel {

    private String name;
    @Column(name = "logo_path")
    private String logoPath;
    private Integer tier;
    @Column(name = "parent_tier", columnDefinition = "BINARY(16)")
    private UUID parentTier;

    private Integer order;

    @Builder
    public CompetitionLevel(UUID id,String name, String logoPath) {
        super(id);
        this.name = name;
        this.logoPath = logoPath;
    }

    @Override
    public int compareTo(BaseModel o) {
        CompetitionLevel level = (CompetitionLevel) o;
        final Integer order1 = this.order != null ? order : 100;
        final Integer order2 = level.getOrder() != null ? level.getOrder() : 100;
        return order1.compareTo(order2);
    }
}
