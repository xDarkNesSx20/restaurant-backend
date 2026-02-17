package com.nisapps.restaurant.services.mappers;

import com.nisapps.restaurant.api.dto.OrderDTOs.*;
import com.nisapps.restaurant.domain.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TableMapper.class})
public interface OrderMapper {
    Order toEntity(OrderCreateRequest request);
}
