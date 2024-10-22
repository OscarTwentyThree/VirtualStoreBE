package com.virtualstore.virtualstore.mappers;

import java.util.List;

import org.mapstruct.*;


import com.virtualstore.virtualstore.dtos.RoleSummary;
import com.virtualstore.virtualstore.entities.Role;



@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    RoleSummary privilegetoPrivilegeSummary(Role role);
    List<RoleSummary> privilegestoPrivilegeSummaries(List<Role> role);   

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRoleFromDto(RoleSummary roleSummary, @MappingTarget Role role);
}