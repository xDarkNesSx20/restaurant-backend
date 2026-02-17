package com.nisapps.restaurant.services.mappers;

import com.nisapps.restaurant.api.dto.TurnDTOs.*;
import com.nisapps.restaurant.domain.entities.Turn;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = EmployeeMapper.class)
public interface TurnMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "day", source = "day")
    Turn toEntity(TurnCreateRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, ignoreByDefault = true)
    @Mapping(target = "startTime", source = "startTime")
    @Mapping(target = "endTime", source = "endTime")
    void patch(TurnUpdateRequest request, @MappingTarget Turn entity);

    @Mapping(target = "employeePublicId", source = "employee.user.publicId")
    @Mapping(target = "day", source = "day")
    TurnResponse toResponse(Turn entity);

    @Mapping(target = "employee", source = "employee")
    @Mapping(target = "day", source = "day")
    TurnFullResponse toFullResponse(Turn entity);
}
