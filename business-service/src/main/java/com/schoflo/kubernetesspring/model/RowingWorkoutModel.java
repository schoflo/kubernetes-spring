package com.schoflo.kubernetesspring.model;

import com.schoflo.kubernetesspring.entity.rowing.RowingWorkout;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.sql.Time;

/**
 * DTO for {@link RowingWorkout}
 */
@Value
public class RowingWorkoutModel {
    @NotNull
    Long id;
    @NotNull
    Integer strokes;
    @NotNull
    Integer distance;
    @NotNull
    Time time;
    Integer calories;
    Long rowingSessionId;
}