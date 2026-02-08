package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}
