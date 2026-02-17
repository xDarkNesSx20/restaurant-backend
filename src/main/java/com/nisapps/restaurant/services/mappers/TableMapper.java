package com.nisapps.restaurant.services.mappers;

import com.nisapps.restaurant.api.dto.TableDTOs.*;
import com.nisapps.restaurant.domain.entities.Table;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface TableMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    Table toEntity(TableCreateRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void patch(TableUpdateRequest request, @MappingTarget Table table);

    @Mapping(target = "type", source = "type")
    TableResponse toResponse(Table table);

    Set<TableResponse> toSetResponse(Set<Table> tables);
}
