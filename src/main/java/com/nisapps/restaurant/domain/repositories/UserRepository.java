package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
