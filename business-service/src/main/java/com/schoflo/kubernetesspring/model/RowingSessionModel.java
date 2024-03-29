package com.schoflo.kubernetesspring.model;

import com.schoflo.kubernetesspring.entity.rowing.RowingSession;
import com.schoflo.kubernetesspring.util.RowingMode;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * DTO for {@link RowingSession}
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RowingSessionModel {
    Long id;
    @NotNull
    RowingMode rowingMode;
    RowingIntervalModel rowingInterval;
    @NotNull
    Long workoutTime;
    @NotNull
    LocalDate workoutDate;
    @NotNull
    Integer strokes;
    @NotNull
    Integer distance;
    Integer calories;
}