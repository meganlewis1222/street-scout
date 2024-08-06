package xyz.streetscout.vendor.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import xyz.streetscout.vendor.entity.Vendor;
import xyz.streetscout.vendor.repository.VendorRepository;

@Profile("!prod")
@Configuration
public class VendorConfig {

    @Bean
    CommandLineRunner vendorCommandLineRunner(VendorRepository vendorRepository) {

        return args -> {
            createVendor(vendorRepository);
        };
    }

    private static void createVendor(VendorRepository vendorRepository) {
        Vendor vendor = new Vendor();
        vendor.setName("Chow Town");
        vendor.setEmail("chow@town.com");
        vendorRepository.save(vendor);
    }
}
