package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Booking;
import com.nisapps.restaurant.domain.enums.BookingStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT B.id FROM Booking B WHERE B.publicId = :publicId")
    Optional<Long> findIdByPublicId(@Param("publicId") String publicId);

    boolean existsByPublicId(String publicId);

    @EntityGraph(attributePaths = {"customer", "order", "tables"})
    @Query("SELECT B FROM Booking B WHERE B.id = :id")
    Optional<Booking> findWithDetails(@Param("id") Long id);

    @EntityGraph(attributePaths = {"customer", "order", "tables"})
    @Query("SELECT B FROM Booking B")
    Page<Booking> findAllWithDetails(Pageable pageable);

    List<Booking> findByCustomer_Id(Long customerId);

    List<Booking> findByStatus(BookingStatus status);

    List<Booking> findByDate(LocalDate date);

    Page<Booking> findByDateBetween(LocalDate start, LocalDate end, Pageable pageable);

    Page<Booking> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to, Pageable pageable);

    List<Booking> findByDateAndStartHourBetween(LocalDate date, LocalTime start, LocalTime end);

    List<Booking> findByDateAndStatus(LocalDate date, BookingStatus status);

    @Query(value = """
                SELECT EXISTS(
                    SELECT 1 FROM bookings B WHERE B.date = :date AND B.start_hour BETWEEN :start AND :end
                        AND B.status NOT IN ('CANCELLED', 'NO_SHOW')
                        AND (SELECT BT.table_id FROM booking_tables WHERE BT.booking_id = B.id) && :tablesIds
                )
            """,
            nativeQuery = true)
    boolean isBooked(LocalDate date, LocalTime start, LocalTime end, Collection<Long> tablesIds);
}
