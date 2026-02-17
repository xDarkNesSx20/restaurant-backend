package com.nisapps.restaurant.services.mappers;

import com.nisapps.restaurant.api.dto.ProductDTOs.*;
import com.nisapps.restaurant.domain.entities.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "slug", ignore = true)
    @Mapping(target = "available", ignore = true)
    Product toEntity(ProductCreateRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "slug", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "category", ignore = true)
    void patch(ProductUpdateRequest request, @MappingTarget Product entity);

    @Mapping(target = "category", source = "category")
    ProductResponse toResponse(Product entity);

    @Mapping(target = "category", source = "category")
    ProductSummary toSummary(Product entity);
}
