package com.nisapps.restaurant.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PromotionDTOs {
    public record PromotionCreateRequest(@NotBlank String name, String description,
                                         @Positive @NotNull Integer discountPercent,
                                         @FutureOrPresent @NotNull @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startAt,
                                         @Future @NotNull @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endAt,
                                         @NotBlank String type) implements Serializable {
    }

    public record PromotionUpdateRequest(String name, String description, @Positive Integer discountPercent,
                                         @FutureOrPresent @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startAt,
                                         @FutureOrPresent @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endAt,
                                         String type, Boolean active) implements Serializable {
    }

    public record PromotionResponse(String publicId, String code, String name, String description, Integer discountPercent,
                                    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startAt,
                                    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endAt,
                                    String type, Boolean active) implements Serializable {
    }
}
