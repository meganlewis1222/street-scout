package xyz.streetscout.customer.dto;

import java.util.Set;

public record CustomerUpdate(
        String name,
        Set<String> favouriteVendors
) {
}
