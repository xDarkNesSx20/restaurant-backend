package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Config, Long> {
    Optional<Config> findByKeyIgnoreCase(String key);

    boolean existsByKeyIgnoreCase(String key);

    @Modifying
    void deleteByKeyIgnoreCase(String key);
}
