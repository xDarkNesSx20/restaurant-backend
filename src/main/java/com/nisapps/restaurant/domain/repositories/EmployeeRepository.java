package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByActive(boolean active);

    List<Employee> findByHiredAtBetween(LocalDate from, LocalDate to);

    List<Employee> findBySalaryGreaterThanEqual(BigDecimal minSalary);

    List<Employee> findBySalaryLessThanEqual(BigDecimal maxSalary);

    @Query("SELECT E FROM Employee E JOIN FETCH E.user WHERE E.id = :id")
    Optional<Employee> findByIdWithDetails(@Param("id") Long id);

    @Query("SELECT E FROM Employee E JOIN FETCH E.user")
    List<Employee> findAllWithDetails();

    boolean existsByUser_PublicId(String userPublicId);

    Optional<Employee> findByUser_PublicId(String userPublicId);
}
