package xyz.streetscout.customer.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.streetscout.customer.dto.CustomerProfile;
import xyz.streetscout.customer.dto.CustomerUpdate;
import xyz.streetscout.customer.dto.RegisterCustomer;
import xyz.streetscout.customer.entity.Customer;
import xyz.streetscout.customer.mapper.CustomerMapper;
import xyz.streetscout.customer.repository.CustomerRepository;
import xyz.streetscout.vendor.entity.Vendor;
import xyz.streetscout.vendor.repository.VendorRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    @Override
    public CustomerProfile addCustomer(RegisterCustomer registerCustomer) {
        Customer customer=new Customer();
        customer.setEmail(registerCustomer.email());
        customer.setName(registerCustomer.name());

        Customer savedCustomer=customerRepository.save(customer);

        return new CustomerProfile(savedCustomer.getId(), savedCustomer.getName(), savedCustomer.getEmail(), null);
    }

    /**
     * @return CustomerProfile
     */
    @Override
    public CustomerProfile getCustomerProfile(Long customerId) {
        Customer customer = findById(customerId);
        return customerMapper.toProfile(customer);
    }

    @Override
    public CustomerProfile getCustomerProfileByEmail(String email) {
        Customer customer=customerRepository.findByEmail(email);
        return customerMapper.toProfile(customer);
    }

    /**
     * @param customerUpdate CustomerUpdate details
     * @return CustomerProfile
     */
    @Override
    public CustomerProfile updateCustomerProfile(Long customerId, CustomerUpdate customerUpdate) {
        Customer customer = findById(customerId);

        if (customerUpdate.favouriteVendors() != null && !customerUpdate.favouriteVendors().isEmpty()) {
            Set<String> updatedVendors = customer.getFavouriteVendors();
            updatedVendors.addAll(customerUpdate.favouriteVendors());
            Set<String> uniqueVendors = new HashSet<>(updatedVendors);;
            customer.setFavouriteVendors(uniqueVendors);
        }

        customerMapper.update(customerUpdate, customer);
        Customer saved = customerRepository.save(customer);
        return customerMapper.toProfile(saved);

    }

    /**
     * @param customerId Customer id
     * @param vendorId   Vendor id
     * @return FavoritesList
     */
    @Override
    public CustomerProfile addFavorite(Long customerId, Long vendorId) {
        Customer customer = findById(customerId);
        Vendor vendor = findVendorById(vendorId);

        customer.addFavorite(vendor);
        Customer saved = customerRepository.save(customer);

        return customerMapper.toProfile(saved);
    }

    private Vendor findVendorById(Long vendorId) {
        return vendorRepository.findById(vendorId)
                .orElseThrow(() -> new EntityNotFoundException("vendor not found"));
    }

    private Customer findById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("customer not found"));
    }

    /**
     * @param customerId Customer id
     * @param vendorId   Vendor id
     */
    @Override
    public void removeFavorite(Long customerId, Long vendorId) {
        Customer customer = findById(customerId);
        Vendor vendor = findVendorById(vendorId);
        customer.removeFavorite(vendor);
        customerRepository.save(customer);
    }
}
