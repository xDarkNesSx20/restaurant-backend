package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
