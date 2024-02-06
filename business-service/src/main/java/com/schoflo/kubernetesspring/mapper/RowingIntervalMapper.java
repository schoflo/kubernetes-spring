package com.schoflo.kubernetesspring.mapper;

import com.schoflo.kubernetesspring.entity.rowing.RowingInterval;
import com.schoflo.kubernetesspring.model.RowingIntervalModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RowingIntervalMapper {
    RowingInterval toEntity(RowingIntervalModel rowingIntervalModel);

    RowingIntervalModel toDto(RowingInterval rowingInterval);
}