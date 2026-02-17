package com.nisapps.restaurant.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.math.BigDecimal;
import com.nisapps.restaurant.api.dto.ProductDTOs.ProductSummary;

public class OrderItemDTOs {
    public record OrderItemCreateRequest(@NotBlank String productSlug, @Positive Integer amount,
                                         String note) implements Serializable {
    }

    public record OrderItemUpdateRequest(@Positive Integer amount, @Positive BigDecimal unitPrice,
                                         String note) implements Serializable {
    }

    public record OrderItemResponse(Long id, String orderPublicId, String productSlug, Integer amount,
                                    BigDecimal unitPrice, BigDecimal subtotal, String note) implements Serializable {
    }

    public record OrderItemFullResponse(Long id, String orderPublicId, ProductSummary product, Integer amount,
                                        BigDecimal unitPrice, BigDecimal subtotal,
                                        String note) implements Serializable {
    }
}
