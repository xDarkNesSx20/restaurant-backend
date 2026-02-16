package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Product;
import com.nisapps.restaurant.domain.enums.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNameIgnoreCase(String name);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategory(ProductCategory category);

    List<Product> findByAvailable(boolean available);

    List<Product> findByCategoryAndPriceLessThanEqualAndAvailableTrue(ProductCategory category, BigDecimal price);

    boolean existsBySlug(String slug);
    Optional<Long> findIdBySlug(String slug);
}
