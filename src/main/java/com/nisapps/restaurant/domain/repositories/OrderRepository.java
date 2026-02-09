package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Order;
import com.nisapps.restaurant.domain.enums.OrderStatus;
import com.nisapps.restaurant.domain.enums.OrderType;
import com.nisapps.restaurant.domain.enums.PaymentMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Long> findIdByPublicId(String publicId);

    boolean existsByPublicId(String publicId);

    @Query("SELECT O FROM Order O JOIN FETCH O.customer JOIN FETCH O.tables WHERE O.id = :id")
    Optional<Order> findByIdWithDetails(@Param("id") Long id);

    List<Order> findByCustomer_Id(Long customerId);

    List<Order> findByCustomer_IdAndStatus(Long customerId, OrderStatus status);

    @Query(value = "SELECT O FROM orders O WHERE O.created_at::date = :createdAtDate", nativeQuery = true)
    List<Order> findByCreatedAtDate(@Param("createdAtDate") LocalDateTime createdAtDate);

    Page<Order> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to, Pageable pageable);

    Page<Order> findByType(OrderType type, Pageable pageable);

    Page<Order> findByStatus(OrderStatus status, Pageable pageable);

    List<Order> findByCustomer_IdAndType(Long customerId, OrderType type);

    Page<Order> findByPaymentMethod(PaymentMethod paymentMethod, Pageable pageable);

    Page<Order> findByPaidTrue(Pageable pageable);

    List<Order> findByPaidFalse();

    Page<Order> findByTypeAndStatus(OrderType type, OrderStatus status, Pageable pageable);
}
