package db.entities.company;

import db.entities.driver.Driver;
import db.entities.freight.Freight;
import db.entities.vehicle.Vehicle;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "company")
    private Set<Driver> drivers;

    @OneToMany(mappedBy = "company")
    private Set<Vehicle> vehicles;

    @OneToMany(mappedBy = "company")
    private Set<Freight> freights;

    public Company() {}

    public Company(String name, Set<Driver> drivers, Set<Vehicle> vehicles, Set<Freight> freights) {
        this.name = name;
        this.drivers = drivers;
        this.vehicles = vehicles;
        this.freights = freights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setFreights(Set<Freight> freights) {
        this.freights = freights;
    }

    public Set<Freight> getFreights() {
        return freights;
    }
}
