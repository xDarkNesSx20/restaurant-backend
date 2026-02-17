package com.nisapps.restaurant.api.dto;

import com.nisapps.restaurant.api.dto.UserDTOs.UserSummary;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeDTOs {
    public record EmployeeCreateRequest(@NotBlank String userPublicId, @PastOrPresent @NotNull LocalDate hiredAt,
                                        @Positive BigDecimal salary) implements Serializable {
    }

    public record EmployeeUpdateRequest(@Positive BigDecimal salary, Boolean active) implements Serializable {
    }

    public record EmployeeResponse(UserSummary user, LocalDate hiredAt, BigDecimal salary,
                                   Boolean active) implements Serializable {
    }
}
