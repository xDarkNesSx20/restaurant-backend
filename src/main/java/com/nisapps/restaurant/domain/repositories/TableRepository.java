package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Table;
import com.nisapps.restaurant.domain.enums.TableType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TableRepository extends JpaRepository<Table, Long> {
    List<Table> findByType(TableType type);
    Optional<Table> findByNumber(Integer number);
    List<Table> findByCapacityGreaterThanEqual(Integer capacity);
    List<Table> findByActive(Boolean active);
}
