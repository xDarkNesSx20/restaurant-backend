package com.nisapps.restaurant.services.mappers;

import com.nisapps.restaurant.api.dto.OrderDTOs.*;
import com.nisapps.restaurant.domain.entities.Order;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TableMapper.class})
public interface OrderMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "type", source = "type")
    @Mapping(target = "paymentMethod", source = "paymentMethod")
    @Mapping(target = "notes", source = "notes")
    Order toEntity(OrderCreateRequest request);

    @BeanMapping(ignoreByDefault = true, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "paymentMethod", source = "paymentMethod")
    @Mapping(target = "notes", source = "notes")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "total", source = "total")
    @Mapping(target = "paid", source = "paid")
    void patch(OrderUpdateRequest request, @MappingTarget Order order);

    @Mapping(target = "customerPublicId", source = "customer.publicId")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "paymentMethod", source = "paymentMethod")
    OrderResponse toResponse(Order order);

    @Mapping(target = "customer", source = "customer")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "paymentMethod", source = "paymentMethod")
    OrderResponseWithCustomer toResponseWithCustomer(Order order);

    @Mapping(target = "customer", source = "customer")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "paymentMethod", source = "paymentMethod")
    @Mapping(target = "tables", source = "tables")
    OrderFullResponse toFullResponse(Order order);

    @Mapping(target = "status", source = "status")
    @Mapping(target = "paymentMethod", source = "paymentMethod")
    OrderSummary toSummary(Order order);
}
