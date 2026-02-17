package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @EntityGraph(attributePaths = {"user"})
    List<Employee> findByActive(boolean active);

    @EntityGraph(attributePaths = {"user"})
    List<Employee> findByHiredAtBetween(LocalDate from, LocalDate to);

    @EntityGraph(attributePaths = {"user"})
    List<Employee> findBySalaryGreaterThanEqual(BigDecimal minSalary);

    @EntityGraph(attributePaths = {"user"})
    List<Employee> findBySalaryLessThanEqual(BigDecimal maxSalary);

    @Query("SELECT E FROM Employee E WHERE E.id = :id")
    @EntityGraph(attributePaths = {"user"})
    Optional<Employee> findByIdWIthDetails(@Param("id") Long id);

    @Override
    @EntityGraph(attributePaths = {"user"})
    List<Employee> findAll();

    boolean existsByUser_PublicId(String userPublicId);

    Optional<Long> findIdByUser_PublicId(String userPublicId);

    @EntityGraph(attributePaths = {"user"})
    Optional<Employee> findByUser_PublicId(String userPublicId);
}
