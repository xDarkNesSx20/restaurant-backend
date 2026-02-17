package com.nisapps.restaurant.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import com.nisapps.restaurant.api.dto.UserDTOs.UserSimpleSummary;
import com.nisapps.restaurant.api.dto.OrderDTOs.OrderSummary;
import com.nisapps.restaurant.api.dto.TableDTOs.TableResponse;

public class BookingDTOs {
    public record BookingCreateRequest(@Future @JsonFormat(pattern = "yyyy-MM-dd") @NotNull LocalDate date,
                                       @JsonFormat(pattern = "HH:mm:ss") @NotNull LocalTime startTime,
                                       @JsonFormat(pattern = "HH:mm:ss") @NotNull LocalTime endTime,
                                       @Positive @NotNull Integer numPeople, String notes,
                                       @NotEmpty Set<Long> tablesId) implements Serializable {
    }

    public record BookingUpdateRequest(@Positive Integer numPeople, String notes) implements Serializable {
    }

    public record BookingFullResponse(String publicId, UserSimpleSummary customer, OrderSummary order,
                                      @JsonFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                      @JsonFormat(pattern = "HH:mm:ss") LocalTime startTime,
                                      @JsonFormat(pattern = "HH:mm:ss") LocalTime endTime, Integer numPeople,
                                      String status,
                                      @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime createdAt,
                                      String notes, Set<TableResponse> tables) implements Serializable {
    }

    public record BookingResponseNoTables(String publicId, UserSimpleSummary customer, OrderSummary order,
                                          @JsonFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                          @JsonFormat(pattern = "HH:mm:ss") LocalTime startTime,
                                          @JsonFormat(pattern = "HH:mm:ss") LocalTime endTime, Integer numPeople,
                                          String status,
                                          @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime createdAt,
                                          String notes) implements Serializable {
    }

    public record BookingResponse(String publicId, UserSimpleSummary customer, String orderPublicId,
                                  @JsonFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                  @JsonFormat(pattern = "HH:mm:ss") LocalTime startTime,
                                  @JsonFormat(pattern = "HH:mm:ss") LocalTime endTime,
                                  Integer numPeople, String status,
                                  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime createdAt,
                                  String notes) implements Serializable {
    }
}
