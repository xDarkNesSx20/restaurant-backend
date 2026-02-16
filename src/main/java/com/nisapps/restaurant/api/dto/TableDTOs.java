package com.nisapps.restaurant.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;

public class TableDTOs {
    public record TableCreateRequest(String type, @Positive @NotNull Integer number,
                                     @Min(2) Integer capacity) implements Serializable {
    }

    public record TableUpdateRequest(String type, @Positive Integer number, @Min(2) Integer capacity,
                                     Boolean active) implements Serializable {
    }

    public record TableResponse(Long id, String type, Integer number, Integer capacity,
                                Boolean active) implements Serializable {
    }
}
