package com.nisapps.restaurant.domain.repositories;

import com.nisapps.restaurant.domain.entities.Review;
import com.nisapps.restaurant.domain.enums.ReviewType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    boolean existsByPublicId(String publicId);

    Optional<Long> findIdByPublicId(String publicId);

    @EntityGraph(attributePaths = {"photosUrl"})
    List<Review> findByUser_Id(Long userId);

    @Query("SELECT R FROM Review R JOIN FETCH R.user LEFT JOIN FETCH R.photosUrl WHERE R.id = :id")
    Optional<Review> findByIdWithDetails(Long id);

    @EntityGraph(attributePaths = {"user", "photosUrl"})
    Page<Review> findByRating(Byte rating, Pageable pageable);

    @EntityGraph(attributePaths = {"user", "photoUrl"})
    Page<Review> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to, Pageable pageable);

    @EntityGraph(attributePaths = {"user", "photosUrl"})
    @Query("SELECT R FROM Review R WHERE R.answeredAt IS NULL")
    Page<Review> findUnansweredReviews(Pageable pageable);

    @EntityGraph(attributePaths = {"user", "photosUrl"})
    Page<Review> findByType(ReviewType type, Pageable pageable);

    @EntityGraph(attributePaths = {"photosUrl", "user"})
    Page<Review> findByTypeAndEntityReviewedId(ReviewType type, String entityReviewedId, Pageable pageable);

    @EntityGraph(attributePaths = {"user", "photosUrl"})
    Page<Review> findByCreatedAtBetweenAndType(LocalDateTime from, LocalDateTime to, ReviewType type, Pageable pageable);

}
