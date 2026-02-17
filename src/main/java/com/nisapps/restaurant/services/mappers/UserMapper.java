package com.nisapps.restaurant.services.mappers;

import com.nisapps.restaurant.api.dto.UserDTOs.*;
import com.nisapps.restaurant.domain.entities.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "surname", source = "surname")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    void patch(UserUpdateRequest request, @MappingTarget User user);

    @Mapping(target = "role", source = "role")
    UserResponse toResponse(User user);

    @Mapping(target = "role", source = "role")
    UserSummary toSummary(User user);

    UserSimpleSummary toSimpleSummary(User user);
}
