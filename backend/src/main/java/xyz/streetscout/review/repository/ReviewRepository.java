package xyz.streetscout.review.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import xyz.streetscout.review.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByVendorId(Long id, PageRequest pageRequest);
}
