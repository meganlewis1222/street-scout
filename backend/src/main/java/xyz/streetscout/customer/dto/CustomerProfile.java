package xyz.streetscout.customer.dto;

import java.util.List;

public record CustomerProfile(
        Long id,
        String name,
        String email,
        List<String> favouriteVendors
) {
}
