package xyz.streetscout.vendor.repository;

import xyz.streetscout.customer.entity.Customer;
import xyz.streetscout.vendor.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Vendor findByEmail(String email);
}
