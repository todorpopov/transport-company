package org.example;

import db.DBUtils;
import db.entities.company.Company;
import db.entities.company.CompanyService;
import db.entities.driver.Driver;
import db.entities.driver.DriverService;
import db.entities.driver.EDriverQualification;
import db.entities.freight.EFreightType;
import db.entities.freight.Freight;
import db.entities.freight.FreightService;
import db.entities.freight.dtos.FreightDTO;
import db.entities.vehicle.EVehicleType;
import db.entities.vehicle.Vehicle;
import db.entities.vehicle.VehicleService;
import exceptions.InvalidFreighException;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//        Main.fileLoaderExample();
//        Main.deleteExample();
//        Main.countFreightsExample();
//        Main.totalFreightsProfitExample();
//        Main.sortedByLocationExample();
        Main.filteredByLocationExample();
    }

    public static void deleteExample() {
        VehicleService vehicleService = VehicleService.getInstance();
        CompanyService companyService = CompanyService.getInstance();

        Company company = new Company("Some Company");
        companyService.saveOneEntity(company);

        Company companyAfterSave = companyService.getOneEntity(1L);

        Vehicle vehicle = new Vehicle(EVehicleType.TRUCK, companyAfterSave);
        vehicleService.saveOneEntity(vehicle);

        Vehicle vehicleAfterSave = vehicleService.getOneEntity(1L);

        Long vehicleId = vehicleAfterSave.getId();

        vehicleService.deleteOne(vehicleId);

        DBUtils.shutdown();
    }

    public static void fileLoaderExample() {
        FreightService freightService = FreightService.getInstance();
        DriverService driverService = DriverService.getInstance();
        CompanyService companyService = CompanyService.getInstance();

        Company company = new Company("Some Company");
        companyService.saveOneEntity(company);

        Company companyAfterSave = companyService.getOneEntity(1L);

        Driver driver = new Driver(1000.0, "Georgi", EDriverQualification.BUS_DRIVERS_LICENSE, companyAfterSave);
        driverService.saveOneEntity(driver);

        Driver driverAfterSave = driverService.getOneEntity(1L);

        try {
            Freight freight1 = new Freight(
                    driverAfterSave,
                    companyAfterSave,
                    "Sofia",
                    "Burgas",
                    LocalDate.of(2025, 1, 1),
                    LocalDate.of(2025, 1, 1),
                    EFreightType.PEOPLE,
                    null,
                    1500.0
            );

            Freight freight2 = new Freight(
                    driverAfterSave,
                    companyAfterSave,
                    "Burgas",
                    "Sofia",
                    LocalDate.of(2025, 1, 1),
                    LocalDate.of(2025, 1, 1),
                    EFreightType.PEOPLE,
                    null,
                    1600.0
            );

            freightService.saveOneEntity(freight1);
            freightService.saveOneEntity(freight2);
        } catch (InvalidFreighException e) {
            System.out.println(e.getMessage());
        }

        Long freightCount = freightService.getNumberOfFreights();
        System.out.printf("Number of freights found: %s", freightCount);

        MasterFileLoader loader = new MasterFileLoader(freightService, "/dev/transport-company");
        try {
            loader.exportFreights();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        DBUtils.shutdown();
    }

    public static void countFreightsExample() {
        FreightService freightService = FreightService.getInstance();
        DriverService driverService = DriverService.getInstance();
        CompanyService companyService = CompanyService.getInstance();

        Company company = new Company("Some Company");
        companyService.saveOneEntity(company);

        Company companyAfterSave = companyService.getOneEntity(1L);

        Driver driver = new Driver(1000.0, "Georgi", EDriverQualification.BUS_DRIVERS_LICENSE, companyAfterSave);
        driverService.saveOneEntity(driver);

        Driver driverAfterSave = driverService.getOneEntity(1L);

        try {
            Freight freight1 = new Freight(
                    driverAfterSave,
                    companyAfterSave,
                    "Sofia",
                    "Burgas",
                    LocalDate.of(2025, 1, 1),
                    LocalDate.of(2025, 1, 1),
                    EFreightType.PEOPLE,
                    null,
                    1500.0
            );

            Freight freight2 = new Freight(
                    driverAfterSave,
                    companyAfterSave,
                    "Burgas",
                    "Sofia",
                    LocalDate.of(2025, 1, 1),
                    LocalDate.of(2025, 1, 1),
                    EFreightType.PEOPLE,
                    null,
                    1600.0
            );

            freightService.saveOneEntity(freight1);
            freightService.saveOneEntity(freight2);
        } catch (InvalidFreighException e) {
            System.out.println(e.getMessage());
        }

        Long freightCount = freightService.getNumberOfFreights();
        System.out.printf("Number of freights found: %s", freightCount);

        DBUtils.shutdown();
    }

    public static void totalFreightsProfitExample() {
        FreightService freightService = FreightService.getInstance();
        DriverService driverService = DriverService.getInstance();
        CompanyService companyService = CompanyService.getInstance();

        Company company = new Company("Some Company");
        companyService.saveOneEntity(company);

        Company companyAfterSave = companyService.getOneEntity(1L);

        Driver driver = new Driver(1000.0, "Georgi", EDriverQualification.BUS_DRIVERS_LICENSE, companyAfterSave);
        driverService.saveOneEntity(driver);

        Driver driverAfterSave = driverService.getOneEntity(1L);

        try {
            Freight freight1 = new Freight(
                    driverAfterSave,
                    companyAfterSave,
                    "Sofia",
                    "Burgas",
                    LocalDate.of(2025, 1, 1),
                    LocalDate.of(2025, 1, 1),
                    EFreightType.PEOPLE,
                    null,
                    1500.0
            );

            Freight freight2 = new Freight(
                    driverAfterSave,
                    companyAfterSave,
                    "Burgas",
                    "Sofia",
                    LocalDate.of(2025, 1, 1),
                    LocalDate.of(2025, 1, 1),
                    EFreightType.PEOPLE,
                    null,
                    1600.0
            );

            freightService.saveOneEntity(freight1);
            freightService.saveOneEntity(freight2);
        } catch (InvalidFreighException e) {
            System.out.println(e.getMessage());
        }

        Double freightCount = freightService.getTotalFreightProfits();
        System.out.printf("Total freights profits are: %s", freightCount);

        DBUtils.shutdown();
    }

    public static void sortedByLocationExample() {
        FreightService freightService = FreightService.getInstance();
        DriverService driverService = DriverService.getInstance();
        CompanyService companyService = CompanyService.getInstance();

        Company company = new Company("Some Company");
        companyService.saveOneEntity(company);

        Company companyAfterSave = companyService.getOneEntity(1L);

        Driver driver = new Driver(1000.0, "Georgi", EDriverQualification.BUS_DRIVERS_LICENSE, companyAfterSave);
        driverService.saveOneEntity(driver);

        Driver driverAfterSave = driverService.getOneEntity(1L);

        try {
            Freight freight1 = new Freight(
                    driverAfterSave,
                    companyAfterSave,
                    "Sofia",
                    "Burgas",
                    LocalDate.of(2025, 1, 1),
                    LocalDate.of(2025, 1, 1),
                    EFreightType.PEOPLE,
                    null,
                    1500.0
            );

            Freight freight2 = new Freight(
                    driverAfterSave,
                    companyAfterSave,
                    "Burgas",
                    "Sofia",
                    LocalDate.of(2025, 1, 1),
                    LocalDate.of(2025, 1, 1),
                    EFreightType.PEOPLE,
                    null,
                    1600.0
            );

            freightService.saveOneEntity(freight1);
            freightService.saveOneEntity(freight2);
        } catch (InvalidFreighException e) {
            System.out.println(e.getMessage());
        }

        List<FreightDTO> list = freightService.getAllFreightsSorted();
        list.forEach(System.out::println);

        DBUtils.shutdown();
    }

    public static void filteredByLocationExample() {
        FreightService freightService = FreightService.getInstance();
        DriverService driverService = DriverService.getInstance();
        CompanyService companyService = CompanyService.getInstance();

        Company company = new Company("Some Company");
        companyService.saveOneEntity(company);

        Company companyAfterSave = companyService.getOneEntity(1L);

        Driver driver = new Driver(1000.0, "Georgi", EDriverQualification.BUS_DRIVERS_LICENSE, companyAfterSave);
        driverService.saveOneEntity(driver);

        Driver driverAfterSave = driverService.getOneEntity(1L);

        try {
            Freight freight1 = new Freight(
                    driverAfterSave,
                    companyAfterSave,
                    "Sofia",
                    "Burgas",
                    LocalDate.of(2025, 1, 1),
                    LocalDate.of(2025, 1, 1),
                    EFreightType.PEOPLE,
                    null,
                    1500.0
            );

            Freight freight2 = new Freight(
                    driverAfterSave,
                    companyAfterSave,
                    "Burgas",
                    "Sofia",
                    LocalDate.of(2025, 1, 1),
                    LocalDate.of(2025, 1, 1),
                    EFreightType.PEOPLE,
                    null,
                    1600.0
            );

            freightService.saveOneEntity(freight1);
            freightService.saveOneEntity(freight2);
        } catch (InvalidFreighException e) {
            System.out.println(e.getMessage());
        }

        List<FreightDTO> list = freightService.filterByLocation("Burgas");
        list.forEach(System.out::println);

        DBUtils.shutdown();
    }
}