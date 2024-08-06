package xyz.streetscout.vendor.service;

import xyz.streetscout.vendor.dto.VendorDetails;
import xyz.streetscout.vendor.dto.VendorList;
import xyz.streetscout.vendor.dto.VendorRegistration;
import xyz.streetscout.vendor.dto.VendorUpdate;

public interface VendorService {

    VendorList getAllVendors();

    VendorDetails getVendorById(Long vendorId);

    VendorDetails registerVendor(VendorRegistration vendorRegistration);

    VendorDetails updateVendor(VendorUpdate vendorUpdate);

    void deactivateVendor(Long vendorId);
}
