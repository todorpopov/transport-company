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

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Driver> drivers;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;

    @OneToMany(mappedBy = "company" , cascade = CascadeType.ALL)
    private Set<Freight> freights;

    @ManyToMany(mappedBy = "companies", cascade = CascadeType.PERSIST)
    private Set<Client> clients;

    public Company() {
    }

    public Company(String name, Set<Driver> drivers, Set<Vehicle> vehicles, Set<Freight> freights, Set<Client> clients) {
        this.name = name;
        this.drivers = drivers != null ? this.setDriversCompany(drivers) : new HashSet<>();
        this.vehicles = vehicles != null ? this.setVehiclesCompany(vehicles) : new HashSet<>();
        this.freights = freights != null ? this.setFreightsCompany(freights) : new HashSet<>();
        this.clients = clients != null ? this.setClientCompany(clients) : new HashSet<>();
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

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public Set<Freight> getFreights() {
        return freights;
    }

    public Set<Client> getClients() {
        return clients;
    }

    private Set<Driver> setDriversCompany(Set<Driver> drivers) {
        for(Driver driver : drivers) {
            driver.setCompany(this);
        }

        return drivers;
    }

    private Set<Freight> setFreightsCompany(Set<Freight> freights) {
        for(Freight freight : freights) {
            freight.setCompany(this);
        }

        return freights;
    }

    private Set<Vehicle> setVehiclesCompany(Set<Vehicle> vehicles) {
        for(Vehicle vehicle : vehicles) {
            vehicle.setCompany(this);
        }

        return vehicles;
    }

    private Set<Client> setClientCompany(Set<Client> clients) {
        for(Client client : clients) {
            client.setCompany(this);
        }

        return clients;
    }

    public void addDriver(Driver driver) {
        if(this.drivers.add(driver)) {
            driver.setCompany(this);
        }
    }

    public boolean removeDriver(Driver driver) {
        if(this.drivers.remove(driver)) {
            driver.setCompany(null);
            return true;
        }

        return false;
    }
}
