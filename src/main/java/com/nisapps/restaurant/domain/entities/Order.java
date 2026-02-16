package com.nisapps.restaurant.domain.entities;

import com.nisapps.restaurant.domain.enums.OrderStatus;
import com.nisapps.restaurant.domain.enums.OrderType;
import com.nisapps.restaurant.domain.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "public_id", length = 16, updatable = false)
    private String publicId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    @Builder.Default
    private OrderStatus status = OrderStatus.CONFIRMED;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderType type;

    @Column(nullable = false, precision = 10, scale = 2)
    @Builder.Default
    private BigDecimal total = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "payment_method")
    private PaymentMethod paymentMethod;

    @Column(nullable = false)
    @Builder.Default
    private boolean paid = false;

    @Column
    private String notes;

    @ManyToMany
    @JoinTable(
            name = "order_tables", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "table_id")
    )
    private Set<Table> tables = new HashSet<>();

    @PrePersist
    public void onCreate(){
        this.publicId = UUID.randomUUID().toString().substring(0, 16);
    }
}
