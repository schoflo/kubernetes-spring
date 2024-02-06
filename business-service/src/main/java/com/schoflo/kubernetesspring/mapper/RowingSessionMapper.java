package com.schoflo.kubernetesspring.mapper;

import com.schoflo.kubernetesspring.entity.rowing.RowingSession;
import com.schoflo.kubernetesspring.model.RowingSessionModel;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {RowingWorkoutMapper.class})
public interface RowingSessionMapper {
    RowingSession toEntity(RowingSessionModel rowingSessionModel);

    @AfterMapping
    default void linkRowingWorkouts(@MappingTarget RowingSession rowingSession) {
        rowingSession.getRowingWorkouts().forEach(rowingWorkout -> rowingWorkout.setRowingSession(rowingSession));
    }

    RowingSessionModel toDto(RowingSession rowingSession);
}