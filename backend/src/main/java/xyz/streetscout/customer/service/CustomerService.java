package xyz.streetscout.customer.service;

import xyz.streetscout.customer.dto.CustomerProfile;
import xyz.streetscout.customer.dto.CustomerUpdate;
import xyz.streetscout.customer.dto.FavoritesList;
import xyz.streetscout.customer.dto.VendorFavorite;

public interface CustomerService {
    CustomerProfile getCustomerProfile();

    CustomerProfile updateCustomerProfile(CustomerUpdate customerUpdate);

    FavoritesList addFavorite(VendorFavorite vendorFavorite);

    void removeFavorite(VendorFavorite vendorFavorite);
}
