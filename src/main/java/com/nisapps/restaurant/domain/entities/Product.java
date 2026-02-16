package com.nisapps.restaurant.domain.entities;

import com.nisapps.restaurant.domain.enums.ProductCategory;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.Normalizer;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String name;

    @Column(nullable = false)
    private String slug;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductCategory category;

    @Column
    @Builder.Default
    private boolean available = true;

    @Column(nullable = false, unique = true, name = "photo_url")
    private String photoUrl;

    @PrePersist
    protected void generateSlug(){
        if (this.slug.isBlank()){
            var normalized = Normalizer.normalize(this.name, Normalizer.Form.NFD);
            var cleaned = normalized.replaceAll("\\p{M}", "");
            this.slug = cleaned.toLowerCase()
                    .replaceAll("[^a-z0-9\\s-]", "")
                    .replaceAll("\\s+", "-")
                    .replaceAll("-+", "-");
        }
    }
}
