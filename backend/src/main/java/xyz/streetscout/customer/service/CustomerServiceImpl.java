package xyz.streetscout.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.streetscout.customer.dto.CustomerProfile;
import xyz.streetscout.customer.dto.CustomerUpdate;
import xyz.streetscout.customer.dto.FavoritesList;
import xyz.streetscout.customer.dto.VendorFavorite;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CustomerServiceImpl implements CustomerService {

    /**
     * @return CustomerProfile
     */
    @Override
    public CustomerProfile getCustomerProfile() {
        return null;
    }

    /**
     * @param customerUpdate CustomerUpdate details
     * @return CustomerProfile
     */
    @Override
    public CustomerProfile updateCustomerProfile(CustomerUpdate customerUpdate) {
        return null;
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

    }
}
