package com.nisapps.restaurant.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import com.nisapps.restaurant.api.dto.UserDTOs.UserSimpleSummary;
import com.nisapps.restaurant.api.dto.TableDTOs.TableResponse;

public class OrderDTOs {
    public record OrderCreateRequest(@NotBlank String customerPublicId, @NotBlank String type,
                                     @NotBlank String paymentMethod,
                                     String notes, @NotEmpty Set<Long> tablesId) implements Serializable {
    }

    public record OrderUpdateRequest(String paymentMethod, String status, @Size(min = 1) String notes,
                                     @PositiveOrZero BigDecimal total,
                                     boolean paid) implements Serializable {
    }

    public record OrderResponse(String publicId, String customerPublicId, String status,
                                @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime createdAt,
                                @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime givenAt,
                                String type, BigDecimal total, String paymentMethod,
                                boolean paid, String notes) implements Serializable {
    }

    public record OrderResponseWithCustomer(String publicId, UserSimpleSummary customer, String status,
                                            @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime createdAt,
                                            @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime givenAt,
                                            String type, BigDecimal total, String paymentMethod,
                                            boolean paid, String notes) implements Serializable {
    }

    public record OrderFullResponse(String publicId, UserSimpleSummary customer, String status,
                                    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime createdAt,
                                    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime givenAt,
                                    String type, BigDecimal total, String paymentMethod,
                                    boolean paid, String notes, Set<TableResponse> tables) implements Serializable {
    }

    public record OrderSummary(String publicId, String status, LocalDateTime createdAt, BigDecimal total,
                               String paymentMethod) implements Serializable {
    }
}
