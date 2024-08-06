package xyz.streetscout.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.streetscout.customer.dto.CustomerProfile;
import xyz.streetscout.customer.dto.CustomerUpdate;
import xyz.streetscout.customer.dto.FavoritesList;
import xyz.streetscout.customer.dto.VendorFavorite;
import xyz.streetscout.customer.entity.Customer;
import xyz.streetscout.customer.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    /**
     * @return CustomerProfile
     */
    @Override
    public CustomerProfile getCustomerProfile(Long customerId) {
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        return customerOpt.map(customer -> new CustomerProfile(customer.getName())).orElse(null);
    }

    /**
     * @param customerUpdate CustomerUpdate details
     * @return CustomerProfile
     */
    @Override
    public CustomerProfile updateCustomerProfile(Long customerId,CustomerUpdate customerUpdate) throws Exception {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->new Exception("customer not found"));

            if (customerUpdate.favouriteVendors() != null && !customerUpdate.favouriteVendors().isEmpty()) {
                List<String> updatedVendors = customer.getFavouriteVendors();
                updatedVendors.addAll(customerUpdate.favouriteVendors());
                List<String> uniqueVendors = updatedVendors.stream().distinct().toList();
                customer.setFavouriteVendors(uniqueVendors);
            }
            customerRepository.save(customer);

        return new CustomerProfile(customer.getName());

    }

    /**
     * @param vendorFavorite Vendor to favorite Details
     * @return FavoritesList
     */
    @Override
    public FavoritesList addFavorite(VendorFavorite vendorFavorite) {
        return null;
    }

    /**
     * @param vendorFavorite  Vendor details
     */
    @Override
    public void removeFavorite(VendorFavorite vendorFavorite) {
        customerRepository.delete(vendorFavorite);

    }
}
