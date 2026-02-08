package com.nisapps.restaurant.domain.entities;


import com.nisapps.restaurant.domain.enums.PromotionType;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "public_id", length = 16, updatable = false)
    private String publicId;

    @Column(unique = true, length = 6)
    private String code;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "discount_percent", nullable = false)
    private Integer discountPercent;

    @Column(name = "start_at", nullable = false)
    private OffsetDateTime startAt;

    @Column(name = "end_at", nullable = false)
    private OffsetDateTime endAt;

    @Builder.Default
    private Boolean active = true;

    @Enumerated(EnumType.STRING)
    private PromotionType type;

    @PrePersist
    public void onCreate(){
        this.publicId = UUID.randomUUID().toString().substring(0, 16);
    }
}
