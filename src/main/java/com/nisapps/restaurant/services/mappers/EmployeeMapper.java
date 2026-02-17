package com.nisapps.restaurant.services.mappers;

import com.nisapps.restaurant.api.dto.EmployeeDTOs.*;
import com.nisapps.restaurant.domain.entities.Employee;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface EmployeeMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "hiredAt", source = "hiredAt")
    @Mapping(target = "salary", source = "salary")
    Employee toEntity(EmployeeCreateRequest request);

    @BeanMapping(ignoreByDefault = true, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "salary", source = "salary")
    @Mapping(target = "active", source = "active")
    void patch(EmployeeUpdateRequest request, @MappingTarget Employee entity);

    @Mapping(target = "user", source = "user")
    EmployeeResponse toResponse(Employee entity);
}
