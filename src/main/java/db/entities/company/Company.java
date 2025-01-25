package db.entities.company;

import db.entities.client.Client;
import db.entities.driver.Driver;
import db.entities.freight.Freight;
import db.entities.vehicle.Vehicle;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Driver> drivers;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Freight> freights;

    @ManyToMany(mappedBy = "companies", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Client> clients;

    public Company() {
    }

    public Company(
            String name,
            Set<Driver> drivers,
            Set<Vehicle> vehicles,
            Set<Freight> freights,
            Set<Client> clients
    ) {
        this.name = name;
        this.drivers = drivers != null ? drivers : new HashSet<>();
        this.vehicles = vehicles != null ? vehicles : new HashSet<>();
        this.freights = freights != null ? freights : new HashSet<>();
        this.clients = clients != null ? clients : new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void addDriver(Driver driver) {
        this.drivers.add(driver);
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Freight> getFreights() {
        return freights;
    }

    public void addFreight(Freight freight) {
        this.freights.add(freight);
    }

    public void setFreights(Set<Freight> freights) {
        this.freights = freights;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
