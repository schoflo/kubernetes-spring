package com.schoflo.kubernetesspring.model;

import com.schoflo.kubernetesspring.entity.rowing.RowingInterval;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.sql.Time;

/**
 * DTO for {@link RowingInterval}
 */
@Value
public class RowingIntervalModel {
    Long id;
    @NotNull
    Time restTime;
    @NotNull
    Integer repetitions;
    @NotNull
    Integer singleDistance;
}