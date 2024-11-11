package com.virtualstore.virtualstore.mappers;

import java.util.Collection;

import org.mapstruct.*;

import com.virtualstore.virtualstore.dtos.StatusBasicInfo;
import com.virtualstore.virtualstore.entities.Status;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StatusMapper {

    StatusBasicInfo statusToStatusBasicInfo(Status status);
    Collection<StatusBasicInfo> statusToStatusBasicInfos(Collection<Status> status);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void statusBasicInfoToStatus(StatusBasicInfo statusBasicInfo, @MappingTarget Status status);
    
}
