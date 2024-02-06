package com.schoflo.kubernetesspring.model;

import com.schoflo.kubernetesspring.entity.rowing.RowingInterval;
import com.schoflo.kubernetesspring.entity.rowing.RowingSession;
import com.schoflo.kubernetesspring.util.RowingMode;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.Set;

/**
 * DTO for {@link RowingSession}
 */
@Value
public class RowingSessionModel {
    @NotNull
    Long id;
    @NotNull
    RowingMode rowingMode;
    @NotNull
    RowingInterval rowingInterval;
    Set<RowingWorkoutModel> rowingWorkouts;
}