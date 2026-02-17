package com.nisapps.restaurant.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

public class ConfigDTOs {
    public record ConfigCreateRequest(@NotBlank @Pattern(regexp = "^[a-z][a-z0-9._-]*$",
            message = "The key must contain just letters, numbers, dots and dashes."
        ) String key, @NotNull @Valid ConfigValueDTO value) implements Serializable {
    }

    public record ConfigUpdateRequest(@NotNull @Valid ConfigValueDTO value) implements Serializable {
    }

    public record ConfigResponse(String key, ConfigValueDTO value) implements Serializable {
    }


    public record ConfigValueDTO(@NotBlank String type, @NotNull Object value) implements Serializable {
    }
}
