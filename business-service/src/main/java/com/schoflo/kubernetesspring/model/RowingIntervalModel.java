package com.schoflo.kubernetesspring.model;

import com.schoflo.kubernetesspring.entity.rowing.RowingInterval;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

/**
 * DTO for {@link RowingInterval}
 */
@Value
public class RowingIntervalModel {
    Long id;
    @NotNull
    Long restTime;
    @NotNull
    Integer repetitions;
    @NotNull
    Integer singleDistance;
}