package com.nisapps.restaurant.services.mappers;

import com.nisapps.restaurant.api.dto.PromotionDTOs.*;
import com.nisapps.restaurant.domain.entities.Promotion;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "publicId", ignore = true)
    @Mapping(target = "code", ignore = true)
    @Mapping(target = "active", ignore = true)
    Promotion toEntity(PromotionCreateRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "publicId", ignore = true)
    @Mapping(target = "code", ignore = true)
    void patch(PromotionUpdateRequest request, @MappingTarget Promotion entity);

    @Mapping(target = "type", source = "type")
    PromotionResponse toResponse(Promotion promotion);
}
