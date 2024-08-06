package xyz.streetscout.customer.dto;

import java.util.List;

public record CustomerUpdate(
        String name,
        List<String> favouriteVendors
) {
}
