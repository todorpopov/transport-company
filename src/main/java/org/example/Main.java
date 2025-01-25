package org.example;

import db.DBUtils;
import db.entities.client.Client;
import db.entities.company.Company;
import db.entities.company.CompanyDAO;
import db.entities.company.CompanyDTO;
import db.entities.driver.Driver;
import db.entities.driver.EDriverQualification;
import db.entities.freight.EFreightType;
import db.entities.freight.Freight;
import db.entities.vehicle.EVehicleType;
import db.entities.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Context globalContext = Context.getInstance();

        globalContext.getTenant();

        HashSet<Driver> drivers = new HashSet<>();
        Driver driver1 = new Driver("Georgi", EDriverQualification.BUS_DRIVERS_LICENSE, null, null, Double.valueOf(1000));
        Driver driver2 = new Driver("Aleks", EDriverQualification.TANKER_DRIVERS_LICENSE, null, null, Double.valueOf(1000));
        drivers.add(driver1);
        drivers.add(driver2);

        HashSet<Vehicle> vehicles = new HashSet<>();
        Vehicle vehicle1 = new Vehicle(EVehicleType.TRUCK, null);
        Vehicle vehicle2 = new Vehicle(EVehicleType.TANKER, null);
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        HashSet<Freight> freights = new HashSet<>();
        Freight freight1 = new Freight(driver1, null, "Sofia", "Burgas", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 2), EFreightType.PEOPLE, null, Double.valueOf(1000));
        freights.add(freight1);

        HashSet<Client> clients = new HashSet<>();
        Client client1 = new Client("Speedy", false, null);
        clients.add(client1);

        Company company = new Company("Google", drivers, vehicles, freights, clients);

        CompanyDAO.save(company);

        DBUtils.shutdown();
    }
}