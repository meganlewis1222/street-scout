package xyz.streetscout.review.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import xyz.streetscout.review.dto.ReviewCreation;
import xyz.streetscout.review.dto.ReviewDetails;
import xyz.streetscout.review.dto.ReviewList;
import xyz.streetscout.review.entity.Review;
import xyz.streetscout.review.mapper.ReviewMapper;
import xyz.streetscout.review.repository.ReviewRepository;
import xyz.streetscout.vendor.entity.Vendor;
import xyz.streetscout.vendor.repository.VendorRepository;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper = ReviewMapper.INSTANCE;
    private final ReviewRepository reviewRepository;
    private final VendorRepository vendorRepository;

    /**
     * @param vendorId    Vendor id
     * @param pageRequest PageRequest with page and size
     * @return ReviewList
     */
    @Override
    public ReviewList getAllReviews(Long vendorId, PageRequest pageRequest) {
        Page<Review> byVendorId = reviewRepository.findAllByVendorId(vendorId, pageRequest);
        return reviewMapper.toReviewList(byVendorId);
    }

    /**
     * @param vendorId Vendor id
     * @param reviewCreation ReviewCreation with review information
     * @return Review
     */
    @Override
    public ReviewDetails createReview(Long vendorId, ReviewCreation reviewCreation) {
        Vendor vendor = findVendorById(vendorId);
        Review review = reviewMapper.toReview(reviewCreation);
        review.setVendor(vendor);
        review = reviewRepository.save(review);
        return reviewMapper.toReviewDetails(review);
    }

    private Vendor findVendorById(Long vendorId) {
        return vendorRepository.findById(vendorId)
                .orElseThrow(() -> new EntityNotFoundException("vendor not found"));
    }

    /**
     * @param vendorId Vendor id
     * @param reviewId Review id
     * @return ReviewDetails
     */
    @Override
    public ReviewDetails editReview(Long vendorId, Long reviewId) {
        return null;
    }

    /**
     * @param vendorId Vendor id
     * @param reviewId Review id
     */
    @Override
    public void disableReview(Long vendorId, Long reviewId) {

    }
}
