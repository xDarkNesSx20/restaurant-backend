package com.nisapps.restaurant.services.mappers;

import com.nisapps.restaurant.api.dto.ConfigDTOs.*;
import com.nisapps.restaurant.domain.entities.Config;
import com.nisapps.restaurant.domain.utils.ConfigValue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ConfigMapper {
    @Mapping(target = "value", source = "value")
    Config toEntity(ConfigCreateRequest request);

    @Mapping(target = "key", ignore = true)
    @Mapping(target = "value", source = "value")
    void updateEntity(@MappingTarget Config config, ConfigUpdateRequest request);

    @Mapping(target = "value", source = "value")
    ConfigResponse toResponse(Config config);

    ConfigValueDTO toConfigValueDTO(ConfigValue configValue);

    ConfigValue toConfigValue(ConfigValueDTO dto);
}
