package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Promotion;
import com.nisapps.restaurant.domain.enums.PromotionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    boolean existsByPublicId(String publicId);

    Optional<Long> findIdByPublicId(String publicId);

    Optional<Promotion> findByCode(String code);

    List<Promotion> findByActive(boolean active);

    List<Promotion> findByType(PromotionType type);

    List<Promotion> findByActiveAndType(boolean active, PromotionType type);

    List<Promotion> findByStartAtBetween(LocalDateTime start, LocalDateTime end);

    List<Promotion> findByTypeAndStartAtBetween(PromotionType type, LocalDateTime start, LocalDateTime end);

    List<Promotion> findByNameContainingIgnoreCase(String name);
}
