package xyz.streetscout.customer.service;

import xyz.streetscout.customer.dto.CustomerProfile;
import xyz.streetscout.customer.dto.CustomerUpdate;
import xyz.streetscout.customer.dto.RegisterCustomer;

public interface CustomerService {
    CustomerProfile addCustomer(RegisterCustomer registerCustomer);

    CustomerProfile getCustomerProfile(Long customerId);
    CustomerProfile getCustomerProfileByEmail(String email);

    CustomerProfile updateCustomerProfile(Long customerId, CustomerUpdate customerUpdate);

    CustomerProfile addFavorite(Long customerId, Long vendorId);

    void removeFavorite(Long customerId, Long vendorId);
}
