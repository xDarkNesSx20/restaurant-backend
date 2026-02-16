package com.nisapps.restaurant.api.dto;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PromotionDTOs {
    public record PromotionCreateRequest(@NotBlank String name, String description,
                                         @Positive @NotNull Integer discountPercent,
                                         @FutureOrPresent @NotNull LocalDateTime startAt,
                                         @Future @NotNull LocalDateTime endAt,
                                         @NotBlank String type) implements Serializable {
    }

    public record PromotionUpdateRequest(String name, String description, @Positive Integer discountPercent,
                                         @FutureOrPresent LocalDateTime startAt, @FutureOrPresent LocalDateTime endAt,
                                         String type,
                                         Boolean active) implements Serializable {
    }

    public record PromotionResponse(String publicId, String code, String name, String description,
                                    Integer discountPercent, LocalDateTime startAt,
                                    LocalDateTime endAt, String type, Boolean active) implements Serializable {
    }
}
