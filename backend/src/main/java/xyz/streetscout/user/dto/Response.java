package xyz.streetscout.user.dto;

import xyz.streetscout.customer.dto.CustomerProfile;
import xyz.streetscout.vendor.dto.VendorDetails;

public record Response(String message,String token,  VendorDetails vendorDetails, CustomerProfile customerProfile) {

}
