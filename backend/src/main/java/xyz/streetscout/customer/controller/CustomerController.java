package xyz.streetscout.customer.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.streetscout.customer.dto.CustomerProfile;
import xyz.streetscout.customer.dto.CustomerUpdate;
import xyz.streetscout.customer.dto.FavoritesList;
import xyz.streetscout.customer.dto.VendorFavorite;
import xyz.streetscout.customer.service.CustomerService;

@RestController
@RequestMapping("/api/customers/{userId}")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<CustomerProfile> getCustomerProfile(){
        CustomerProfile customer = customerService.getCustomerProfile();
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @PutMapping("")
    public ResponseEntity<CustomerProfile> updateCustomerProfile(@Valid @RequestBody CustomerUpdate customerUpdate){
        CustomerProfile updatedCustomer = customerService.updateCustomerProfile(customerUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCustomer);
    }

    @PostMapping("/favorites")
    public ResponseEntity<FavoritesList> addVendorToFavorites(@Valid @RequestBody VendorFavorite vendorFavorite){
        FavoritesList favorites = customerService.addFavorite(vendorFavorite);
        return ResponseEntity.status(HttpStatus.CREATED).body(favorites);
    }

    @DeleteMapping("/favorites")
    public ResponseEntity<Void> removeVendorFromFavorites(@Valid @RequestBody VendorFavorite vendorFavorite){
        customerService.removeFavorite(vendorFavorite);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
