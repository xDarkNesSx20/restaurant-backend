package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnRepository extends JpaRepository<Turn, Long> {
}
