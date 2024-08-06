package xyz.streetscout.customer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "favourite_vendors",
            joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "vendor_name")
    private List<String> favouriteVendors;
}
