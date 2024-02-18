package com.schoflo.kubernetesspring.model;

import com.schoflo.kubernetesspring.entity.rowing.RowingSession;
import com.schoflo.kubernetesspring.util.RowingMode;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

/**
 * DTO for {@link RowingSession}
 */
@Value
public class RowingSessionModel {
    Long id;
    @NotNull
    RowingMode rowingMode;
    RowingIntervalModel rowingInterval;
    @NotNull
    Long workoutTime;
    @NotNull
    Integer strokes;
    @NotNull
    Integer distance;
}