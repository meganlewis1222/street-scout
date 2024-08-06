package xyz.streetscout.vendor.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.streetscout.vendor.dto.VendorDetails;
import xyz.streetscout.vendor.dto.VendorList;
import xyz.streetscout.vendor.dto.VendorRegistration;
import xyz.streetscout.vendor.dto.VendorUpdate;
import xyz.streetscout.vendor.service.VendorService;

@RestController
@RequestMapping("/api/vendors")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class VendorController {

    private final VendorService vendorService;

    @GetMapping("")
    public ResponseEntity<VendorList> getAllVendors(){
        VendorList vendors = vendorService.getAllVendors();
        return ResponseEntity.status(HttpStatus.OK).body(vendors);
    }

    @GetMapping("/{vendorId}")
    public ResponseEntity<VendorDetails> getVendorById(@PathVariable(name = "vendorId") Long vendorId){
        VendorDetails vendor = vendorService.getVendorById(vendorId);
        return ResponseEntity.status(HttpStatus.OK).body(vendor);
    }

    @PostMapping("")
    public ResponseEntity<VendorDetails> registerVendor(@Valid @RequestBody VendorRegistration vendorRegistration){
        VendorDetails vendor = vendorService.registerVendor(vendorRegistration);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendor);
    }

    @PutMapping("/{vendorId}")
    public ResponseEntity<VendorDetails> updateVendor(@Valid @RequestBody VendorUpdate vendorUpdate){
        VendorDetails vendor = vendorService.updateVendor(vendorUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(vendor);
    }

    @DeleteMapping("/{vendorId}")
    public ResponseEntity<Void> deactivateVendor(@PathVariable Long vendorId){
        vendorService.deactivateVendor(vendorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
