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

    @OneToMany(mappedBy = "company")
    private Set<Driver> drivers = new HashSet<>();

    @OneToMany(mappedBy = "company")
    private Set<Vehicle> vehicles = new HashSet<>();

    @OneToMany(mappedBy = "company")
    private Set<Freight> freights = new HashSet<>();

    @ManyToMany(mappedBy = "companies")
    private Set<Client> clients = new HashSet<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(
            String name,
            Set<Driver> drivers,
            Set<Vehicle> vehicles,
            Set<Freight> freights,
            Set<Client> clients
    ) {
        this.name = name;
        this.drivers.addAll(drivers);
        this.vehicles.addAll(vehicles);
        this.freights.addAll(freights);
        this.clients.addAll(clients);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Freight> getFreights() {
        return freights;
    }

    public void setFreights(Set<Freight> freights) {
        this.freights = freights;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }
}
