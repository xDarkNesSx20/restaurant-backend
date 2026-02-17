package com.nisapps.restaurant.services.mappers;

import com.nisapps.restaurant.api.dto.ReviewDTOs.*;
import com.nisapps.restaurant.domain.entities.Review;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ReviewMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "rating", source = "rating"),
            @Mapping(target = "comment", source = "comment"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "entityReviewedId", source = "entityReviewedId"),
            @Mapping(target = "photosUrl", source = "photosUrls")
    })
    Review toEntity(ReviewCreateRequest request);

    @BeanMapping(ignoreByDefault = true, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "adminAnswer", source = "adminAnswer")
    void patch(ReviewUpdateRequest request, @MappingTarget Review review);

    @Mapping(target = "userPublicId", source = "user.publicId")
    @Mapping(target = "type", source = "type")
    ReviewResponse toResponse(Review review);

    @Mapping(target = "user", source = "user")
    @Mapping(target = "type", source = "type")
    ReviewFullResponse toFullResponse(Review review);
}
