package com.schoflo.kubernetesspring.mapper;

import com.schoflo.kubernetesspring.entity.rowing.RowingSession;
import com.schoflo.kubernetesspring.model.RowingSessionModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {RowingIntervalMapper.class, DurationMapper.class})
public interface RowingSessionMapper {
    RowingSession toEntity(RowingSessionModel rowingSessionModel);

    RowingSessionModel toDto(RowingSession rowingSession);
}