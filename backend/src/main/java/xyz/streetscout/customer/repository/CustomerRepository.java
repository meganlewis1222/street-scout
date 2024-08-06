package xyz.streetscout.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.streetscout.customer.dto.VendorFavorite;
import xyz.streetscout.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    void delete(VendorFavorite vendorFavorite);
}
