package xyz.streetscout.vendor.repository;

import xyz.streetscout.vendor.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
