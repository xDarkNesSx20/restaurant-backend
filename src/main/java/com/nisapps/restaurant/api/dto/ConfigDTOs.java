package com.nisapps.restaurant.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class ConfigDTOs {
    public record ConfigCreateRequest(@NotBlank String key, @NotNull ConfigValueDTO value) implements Serializable {
    }

    public record ConfigUpdateRequest(@NotBlank String key, @NotNull ConfigValueDTO value) implements Serializable {
    }

    public record ConfigResponse(String key, ConfigValueDTO value) implements Serializable {
    }


    public record ConfigValueDTO(@NotBlank String type, @NotNull Object value) implements Serializable {
    }
}
