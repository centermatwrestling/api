package com.centermat.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeightClass {
    private int weight;
    private String suffix;
}
