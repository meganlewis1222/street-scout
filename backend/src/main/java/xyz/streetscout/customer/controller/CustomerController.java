package xyz.streetscout.customer.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.streetscout.customer.dto.CustomerProfile;
import xyz.streetscout.customer.dto.CustomerUpdate;
import xyz.streetscout.customer.service.CustomerService;

@RestController
@RequestMapping("/api/customers/{userId}")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<CustomerProfile> getCustomerProfile(@PathVariable Long userId){
        CustomerProfile customer = customerService.getCustomerProfile(userId);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @PutMapping("")
    public ResponseEntity<CustomerProfile> updateCustomerProfile(@PathVariable Long userId,
                                                                 @Valid @RequestBody CustomerUpdate customerUpdate) {
        CustomerProfile updatedCustomer = customerService.updateCustomerProfile(userId, customerUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCustomer);
    }

    @PostMapping("/favorites/{vendorId}")
    public ResponseEntity<CustomerProfile> addVendorToFavorites(
            @PathVariable("vendorId") Long vendorId, @PathVariable("userId") Long customerId) {

        CustomerProfile profile = customerService.addFavorite(customerId, vendorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(profile);
    }

    @DeleteMapping("/favorites/{vendorId}")
    public ResponseEntity<Void> removeVendorFromFavorites(@PathVariable("vendorId") Long vendorId){
        customerService.removeFavorite(vendorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
