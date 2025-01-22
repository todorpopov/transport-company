package db.entities.freight;

import db.entities.company.Company;
import db.entities.driver.Driver;
import jakarta.persistence.*;


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
    private java.sql.Date startDate;

    @Column(name = "end_date", nullable = false)
    private java.sql.Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EFreightType type;

    @Column(nullable = true)
    private Double cargoWeight;

    public Freight() {}

    public Freight(Driver driver, Company company, String startLocation, String endLocation, java.util.Date startDate, java.util.Date endDate, EFreightType type, Double cargoWeight) {
        this.driver = driver;
        this.company = company;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = new java.sql.Date(startDate.getTime());
        this.endDate = new java.sql.Date(endDate.getTime());
        this.type = type;
        this.cargoWeight = cargoWeight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = new java.sql.Date(startDate.getTime());
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = new java.sql.Date(endDate.getTime());
    }

    public EFreightType getType() {
        return type;
    }

    public void setType(EFreightType type) {
        this.type = type;
    }

    public Double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(Double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }
}
