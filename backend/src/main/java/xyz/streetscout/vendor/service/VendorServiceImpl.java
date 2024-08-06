package xyz.streetscout.vendor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.streetscout.vendor.dto.VendorDetails;
import xyz.streetscout.vendor.dto.VendorList;
import xyz.streetscout.vendor.dto.VendorRegistration;
import xyz.streetscout.vendor.dto.VendorUpdate;
import xyz.streetscout.vendor.repository.VendorRepository;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    /**
     * @return VendorList
     */
    @Override
    public VendorList getAllVendors() {
        return null;
    }

    /**
     * @param vendorId Vendor id
     * @return VendorDetails
     */
    @Override
    public VendorDetails getVendorById(Long vendorId) {
        return null;
    }

    /**
     * @param vendorRegistration Initial Vendor information
     * @return VendorDetails
     */
    @Override
    public VendorDetails registerVendor(VendorRegistration vendorRegistration) {
        return null;
    }

    /**
     * @param vendorUpdate Vendor details to be updated
     * @return VendorDetails with updated values
     */
    @Override
    public VendorDetails updateVendor(VendorUpdate vendorUpdate) {
        return null;
    }

    /**
     * @param vendorId Vendor id
     */
    @Override
    public void deactivateVendor(Long vendorId) {

    }
}
