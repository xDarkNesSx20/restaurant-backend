package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
