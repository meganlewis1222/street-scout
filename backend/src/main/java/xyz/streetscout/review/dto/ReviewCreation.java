package xyz.streetscout.review.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(
    name = "ReviewCreation",
    description = "Schema to hold initial Review info")
public record ReviewCreation(
        @NotNull(message = "Rating must not be null")
        @Min(value = 1, message = "Rating must be greater than 1")
        @Max(value = 5, message = "Rating must be less than 5")
        Integer rating,

        @NotBlank(message = "Text must not be empty")
        @Size(min = 3, message = "Text size must be at least 3 characters")
        String text
) {
}
