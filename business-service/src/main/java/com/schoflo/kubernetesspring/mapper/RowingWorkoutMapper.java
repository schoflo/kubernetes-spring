package com.schoflo.kubernetesspring.mapper;

import com.schoflo.kubernetesspring.entity.rowing.RowingWorkout;
import com.schoflo.kubernetesspring.model.RowingWorkoutModel;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RowingWorkoutMapper {
    @Mapping(source = "rowingSessionId", target = "rowingSession.id")
    RowingWorkout toEntity(RowingWorkoutModel rowingWorkoutModel);

    @Mapping(source = "rowingSession.id", target = "rowingSessionId")
    RowingWorkoutModel toDto(RowingWorkout rowingWorkout);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RowingWorkout partialUpdate(RowingWorkoutModel rowingWorkoutModel, @MappingTarget RowingWorkout rowingWorkout);
}