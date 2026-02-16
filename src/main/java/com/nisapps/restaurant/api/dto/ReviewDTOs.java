package com.nisapps.restaurant.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import com.nisapps.restaurant.api.dto.UserDTOs.UserReviewSummary;

public class ReviewDTOs {
    public record ReviewCreateRequest(@NotBlank String userPublicId, @Min(1) @Max(5) byte rating, String comment,
                                      @NotBlank String type, String entityReviewedId,
                                      Set<String> photosUrls) implements Serializable {
    }

    public record ReviewUpdateRequest(@Min(1) @Max(5) byte rating, String comment,
                                      String adminAnswer) implements Serializable {
    }

    public record ReviewResponse(String publicId, String userPublicId, byte rating, String comment, LocalDateTime createdAt, String type,
                                 String adminAnswer,
                                 LocalDateTime answeredAt, String entityReviewedId,
                                 Set<String> photosUrls) implements Serializable {
    }

    public record ReviewFullResponse(String publicId, UserReviewSummary user, byte rating, String comment, LocalDateTime createdAt, String type,
                                     String adminAnswer,
                                     LocalDateTime answeredAt, String entityReviewedId,
                                     Set<String> photosUrls) implements Serializable {
    }
}
