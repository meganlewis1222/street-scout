package xyz.streetscout.review.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(
    name = "ReviewCreation",
    description = "Schema to hold initial Review information")
public record ReviewCreation(
        @NotNull(message = "Rating must not be null")
        @Min(value = 1, message = "Rating must be greater than 1")
        @Max(value = 5, message = "Rating must be less than 5")
        Integer rating,

        @NotBlank(message = "Text must not be empty")
        String text
) {
}
