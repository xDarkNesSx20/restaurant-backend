package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.User;
import com.nisapps.restaurant.domain.enums.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByPublicId(String publicId);

    boolean existsByEmailIgnoreCase(String email);

    Optional<User> findByEmailIgnoreCase(String email);

    Optional<User> findByPublicId(String publicId);

    Optional<Long> findIdByPublicId(String publicId);

    @Query("SELECT U FROM User U WHERE CONCAT(U.name, ' ', U.surname) LIKE %:fullName%")
    List<User> findByFullNameContaining(String fullName);

    @Query("SELECT U FROM User U WHERE CONCAT(U.name, ' ', U.surname) LIKE %:fullName% AND U.role = :role")
    List<User> findByFullNameContainingAndRole(@Param("fullName") String fullName, @Param("role") Role role);

    Optional<User> findByPhoneNumber(String phoneNumber);

    Page<User> findByRole(Role role, Pageable pageable);

    Page<User> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to, Pageable pageable);

    Page<User> findByActive(boolean active, Pageable pageable);

    Page<User> findByRoleAndCreatedAtBetween(Role role, LocalDateTime from, LocalDateTime to, Pageable pageable);
}
