package com.schoflo.kubernetesspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.time.Duration;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public class DurationMapper {

    public Long asLongInMiliseconds(Duration duration) {
        return duration.toMillis();
    }

    public Duration asDuration(Long miliseconds) {
        return Duration.ofMillis(miliseconds);
    }
}
