package xyz.streetscout.review.dto;

import java.util.List;

public record ReviewList(
        int page,
        int totalPages,
        int pageSize,
        List<ReviewDetails> reviews
) {
}
