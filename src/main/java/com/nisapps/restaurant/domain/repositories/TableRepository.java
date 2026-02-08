package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}
