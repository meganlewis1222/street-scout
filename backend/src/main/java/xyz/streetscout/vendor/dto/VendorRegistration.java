package xyz.streetscout.vendor.dto;

import xyz.streetscout.vendor.entity.Location;
import xyz.streetscout.vendor.entity.MenuItem;
import xyz.streetscout.vendor.entity.OperatingHours;

import java.util.Set;

public record VendorRegistration(String name, String description, Location location, OperatingHours operatingHours, Set<MenuItem> menu) {
}
