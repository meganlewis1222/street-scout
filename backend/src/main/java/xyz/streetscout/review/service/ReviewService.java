package xyz.streetscout.review.service;

import org.springframework.data.domain.PageRequest;
import xyz.streetscout.review.dto.ReviewCreation;
import xyz.streetscout.review.dto.ReviewDetails;
import xyz.streetscout.review.dto.ReviewList;

public interface ReviewService {
    ReviewList getAllReviews(Long vendorId, PageRequest pageRequest);

    ReviewDetails createReview(Long vendorId, ReviewCreation reviewCreation);

    ReviewDetails editReview(Long vendorId, Long reviewId);

    void disableReview(Long vendorId, Long reviewId);
}
