package com.nisapps.restaurant.services.mappers;

import com.nisapps.restaurant.api.dto.BookingDTOs.*;
import com.nisapps.restaurant.domain.entities.Booking;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserMapper.class, OrderMapper.class, TableMapper.class})
public interface BookingMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "date", source = "date")
    @Mapping(target = "startTime", source = "startTime")
    @Mapping(target = "endTime", source = "endTime")
    @Mapping(target = "notes", source = "notes")
    @Mapping(target = "numPeople", source = "numPeople")
    Booking toEntity(BookingCreateRequest request);

    @BeanMapping(ignoreByDefault = true, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "notes", source = "notes")
    @Mapping(target = "numPeople", source = "numPeople")
    void patch(BookingUpdateRequest request, @MappingTarget Booking booking);

    @Mapping(target = "status", source = "status")
    @Mapping(target = "customer", source = "customer")
    @Mapping(target = "orderPublicId", source = "order.publicId")
    BookingResponse toResponse(Booking booking);

    @Mapping(target = "status", source = "status")
    @Mapping(target = "customer", source = "customer")
    @Mapping(target = "order", source = "order")
    BookingResponseNoTables toResponseNoTables(Booking booking);

    @Mapping(target = "status", source = "status")
    @Mapping(target = "customer", source = "customer")
    @Mapping(target = "order", source = "order")
    @Mapping(target = "tables", source = "tables")
    BookingFullResponse toFullResponse(Booking booking);
}
