package com.nisapps.restaurant.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDTOs {
    public record ProductCreateRequest(@NotBlank String name, @NotBlank String description,
                                       @Positive @NotNull BigDecimal price,
                                       @NotBlank String category, @NotBlank String photoUrl) implements Serializable {
    }

    public record ProductUpdateRequest(String description, @Positive BigDecimal price, boolean available,
                                       String photoUrl) implements Serializable {
    }

    public record ProductResponse(String slug, String name, String description, BigDecimal price, String category,
                                  boolean available, String photoUrl) implements Serializable {
    }

    public record ProductSummary(String slug, String name, String category) implements Serializable {}
}
