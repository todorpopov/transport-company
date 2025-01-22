package db.entities.driver;

import db.entities.company.Company;
import db.entities.freight.Freight;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EDriverQualification qualification;

    @OneToMany(mappedBy = "driver")
    private Set<Freight> freights;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
