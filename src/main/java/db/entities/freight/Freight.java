package db.entities.freight;

import db.entities.company.Company;
import db.entities.driver.Driver;
import exceptions.InvalidFreighException;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Freight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(name = "start_location", nullable = false)
    private String startLocation;

    @Column(name = "end_location", nullable = false)
    private String endLocation;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EFreightType type;

    @Column(nullable = true)
    private Double cargoWeight;

    @Column(nullable = false)
    private Double price;

    public Freight() {
    }

    public Freight(
            Driver driver,
            Company company,
            String startLocation,
            String endLocation,
            LocalDate startDate,
            LocalDate endDate,
            EFreightType type,
            Double cargoWeight,
            Double price
    ) throws InvalidFreighException {
        if (type == EFreightType.CARGO && cargoWeight == null) {
            throw new InvalidFreighException("Cargo freights must have weight");
        }

        if (type == EFreightType.PEOPLE && cargoWeight != null) {
            throw new InvalidFreighException("People freights must not have weight");
        }

        this.driver = driver;
        this.company = company;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.cargoWeight = cargoWeight;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Driver getDriver() {
        return driver;
    }

    public Company getCompany() {
        return company;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public EFreightType getType() {
        return type;
    }

    public Double getCargoWeight() {
        return cargoWeight;
    }

    public Double getPrice() {
        return price;
    }
}
