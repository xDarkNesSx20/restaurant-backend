package com.nisapps.restaurant.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalTime;
import com.nisapps.restaurant.api.dto.EmployeeDTOs.EmployeeResponse;

public class TurnDTOs {
    public record TurnCreateRequest(@NotBlank String day,
                                    @NotNull @JsonFormat(pattern = "HH:mm:ss") LocalTime startHour,
                                    @NotNull @JsonFormat(pattern = "HH:mm:ss") LocalTime endHour) implements Serializable {
    }

    public record TurnUpdateRequest(@JsonFormat(pattern = "HH:mm:ss") LocalTime startHour,
                                    @JsonFormat(pattern = "HH:mm:ss") LocalTime endHour) implements Serializable {
    }

    public record TurnResponse(Long id, String employeeUserPublicId, String day,
                               @JsonFormat(pattern = "HH:mm:ss") LocalTime startHour,
                               @JsonFormat(pattern = "HH:mm:ss") LocalTime endHour) implements Serializable {
    }

    public record TurnFullResponse(Long id, EmployeeResponse employee, String day,
                               @JsonFormat(pattern = "HH:mm:ss") LocalTime startHour,
                               @JsonFormat(pattern = "HH:mm:ss") LocalTime endHour) implements Serializable {
    }
}
