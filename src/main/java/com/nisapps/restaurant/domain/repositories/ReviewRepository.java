package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
