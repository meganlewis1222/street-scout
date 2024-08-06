package xyz.streetscout.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.streetscout.review.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
