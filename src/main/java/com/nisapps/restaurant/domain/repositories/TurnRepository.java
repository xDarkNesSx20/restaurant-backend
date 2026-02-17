package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Turn;
import com.nisapps.restaurant.domain.enums.WeekDay;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface TurnRepository extends JpaRepository<Turn, Long> {
    @Query("SELECT T FROM Turn T JOIN FETCH T.employee JOIN FETCH T.employee.user WHERE T.id = :id")
    Optional<Turn> findByIdWithEmployeeInfo(@Param("id") Long id);

    List<Turn> findByEmployee_Id(Long employeeId);

    Optional<Turn> findByEmployee_IdAndDay(Long employeeId, WeekDay day);

    @EntityGraph(attributePaths = {"employee", "employee.user"})
    List<Turn> findByDay(WeekDay day);

    @EntityGraph(attributePaths = {"employee", "employee.user"})
    List<Turn> findByDayAndStartHourBetween(WeekDay day, LocalTime from, LocalTime to);
}
