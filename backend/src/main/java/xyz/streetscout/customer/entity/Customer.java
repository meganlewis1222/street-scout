package xyz.streetscout.customer.entity;

import jakarta.persistence.*;
import lombok.Data;
import xyz.streetscout.vendor.entity.Vendor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "favourite_vendors",
            joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "vendor_name")
    private Set<String> favouriteVendors;

    public void addFavorite(Vendor vendor) {
        if (favouriteVendors == null) {
            favouriteVendors = new HashSet<>();
        }

        favouriteVendors.add(vendor.getName());
    }

    public void removeFavorite(Vendor vendor) {
        if (favouriteVendors == null) {
            favouriteVendors = new HashSet<>();
        }

        favouriteVendors.remove(vendor.getName());
    }
}
