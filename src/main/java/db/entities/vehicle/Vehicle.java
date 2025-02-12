package db.entities.vehicle;

import db.entities.company.Company;
import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EVehicleType type;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public Vehicle() {
    }

    public Vehicle(EVehicleType type, Company company) {
        this.type = type;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EVehicleType getType() {
        return type;
    }

    public void setType(EVehicleType type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
