package xyz.streetscout.vendor.entity;

import jakarta.persistence.*;
import lombok.Data;
import xyz.streetscout.review.entity.Review;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "vendor_photos",
            joinColumns = @JoinColumn(name = "vendor_id"))
    @Column(name = "photos")
    private List<String> photos;

    @OneToOne(mappedBy = "vendor")
    private Location location;

    @OneToOne(mappedBy = "vendor")
    private OperatingHours operatingHours;

    @OneToMany(mappedBy = "vendor")
    @Column(name = "menu")
    private Set<MenuItem> menu = new HashSet<>();

    @OneToMany(mappedBy = "vendor")
    @Column(name = "reviews")
    private List<Review> reviews;

    @Column(name = "email")
    private String email;

}
