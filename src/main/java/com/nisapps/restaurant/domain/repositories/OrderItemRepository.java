package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @EntityGraph(attributePaths = {"product"})
    List<OrderItem> findByOrder_Id(Long orderId);

    Page<OrderItem> findByProduct_Id(Long productId, Pageable pageable);
}
