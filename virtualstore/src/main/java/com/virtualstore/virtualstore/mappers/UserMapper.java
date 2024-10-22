package com.virtualstore.virtualstore.mappers;

import java.util.*;

import org.mapstruct.*;


import com.virtualstore.virtualstore.dtos.UserBasicInfo;
import com.virtualstore.virtualstore.entities.User;



@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserBasicInfo userToUserBasicInfo(User user);
    Collection<UserBasicInfo> usersToUserBasicInfos(Collection<User> users);   

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void userBasicInfoToUser(UserBasicInfo userBasicInfo, @MappingTarget User user);
}
