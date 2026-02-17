package com.nisapps.restaurant.services.mappers;

import com.nisapps.restaurant.api.dto.OrderItemDTOs.*;
import com.nisapps.restaurant.domain.entities.OrderItem;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface OrderItemMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "note", source = "note")
    OrderItem toEntity(OrderItemCreateRequest request);

    @BeanMapping(ignoreByDefault = true, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "note", source = "note")
    @Mapping(target = "unitPrice", source = "unitPrice")
    void patch(OrderItemUpdateRequest request, @MappingTarget OrderItem orderItem);

    @Mapping(target = "orderPublicId", source = "order.publicId")
    @Mapping(target = "productSlug", source = "product.slug")
    OrderItemResponse toResponse(OrderItem orderItem);

    @Mapping(target = "orderPublicId", source = "order.publicId")
    @Mapping(target = "product", source = "product")
    OrderItemFullResponse toFullResponse(OrderItem orderItem);
}
