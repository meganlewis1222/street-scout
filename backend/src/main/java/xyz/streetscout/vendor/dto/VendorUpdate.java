package xyz.streetscout.vendor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import xyz.streetscout.review.entity.Review;
import xyz.streetscout.vendor.entity.Location;
import xyz.streetscout.vendor.entity.MenuItem;
import xyz.streetscout.vendor.entity.OperatingHours;

import java.util.List;
import java.util.Set;

@Schema(
    name = "VendorUpdate",
    description = "Schema to hold updated Vendor information")
public record VendorUpdate(
        String description,
        List<String> photos,
        Location location,
        OperatingHours operatingHours,
        Set<MenuItem> menu) {
}
