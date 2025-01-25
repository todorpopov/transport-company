package org.example;

import db.DBUtils;

import db.entities.company.Company;
import db.entities.company.CompanyDAO;
import db.entities.company.CompanyDTO;
import db.entities.company.CompanyService;
import db.entities.driver.*;
import db.entities.freight.*;
import exceptions.InvalidFreighException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InvalidFreighException {
        FreightDAO freightDAO = new FreightDAO();
        FreightService freightService = new FreightService(freightDAO);

        CompanyDAO companyDAO = new CompanyDAO();
        CompanyService companyService = new CompanyService(companyDAO);

        DriverDAO driverDAO = new DriverDAO();
        DriverService driverService = new DriverService(driverDAO);

        Company company = new Company("Union Ivkoni", null, null, null, null);
        Set<Driver> drivers = new HashSet<>();
        Driver driver1 = new Driver("Georgi", EDriverQualification.BUS_DRIVERS_LICENSE, null, company, Double.valueOf(1000));
        drivers.add(driver1);

        company.setDrivers(drivers);

        Set<Freight> freights = new HashSet<Freight>();
        Freight freight1 = new Freight(driver1, company, "Sofia", "Burgas", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 1), EFreightType.PEOPLE, null, Double.valueOf(2500));
        Freight freight2 = new Freight(driver1, company, "Burgas", "Sofia", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 1), EFreightType.PEOPLE, null, Double.valueOf(2500));
        freights.add(freight1);
        freights.add(freight2);

        company.setFreights(freights);
        driver1.setFreights(freights);

        companyService.saveOne(CompanyDTO.toDTO(company));
        driverService.saveOne(DriverDTO.toDTO(driver1));
        freightService.saveOne(FreightDTO.toDTO(freight1));
        freightService.saveOne(FreightDTO.toDTO(freight2));

        MasterFileLoader masterLoader = new MasterFileLoader(freightService, System.getenv("HOME"));
        try {
            masterLoader.exportFreights();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        DBUtils.shutdown();
    }
}