package com.virtualstore.virtualstore.mappers;

import java.util.List;

import org.mapstruct.*;


import com.virtualstore.virtualstore.dtos.PrivilegeSummary;
import com.virtualstore.virtualstore.entities.Privilege;



@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrivilegeMapper {

    PrivilegeSummary privilegetoPrivilegeSummary(Privilege privilege);
    List<PrivilegeSummary> privilegestoPrivilegeSummaries(List<Privilege> privileges);   

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePrivilegeFromDto(PrivilegeSummary privilegeSummary, @MappingTarget Privilege privilege);
}
