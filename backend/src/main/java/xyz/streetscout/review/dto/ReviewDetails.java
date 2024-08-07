package xyz.streetscout.review.dto;

import java.time.LocalDateTime;

public record ReviewDetails(
        Long id,
        Long reviewerId,
        Long vendorId,
        String vendor,
        String reviewer,
        Integer rating,
        String text,
        LocalDateTime createdAt
) {
}
