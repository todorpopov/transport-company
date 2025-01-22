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
}
