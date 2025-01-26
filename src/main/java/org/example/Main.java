package org.example;

import db.DBUtils;
import db.entities.company.Company;
import db.entities.company.CompanyService;
import db.entities.driver.Driver;
import db.entities.driver.DriverService;
import db.entities.driver.EDriverQualification;
import db.entities.driver.dtos.DriverDTO;
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
//        Main.freightQueriesAndFileExportExample();
        Main.driverQueriesExample();
    }

    public static void driverQueriesExample() {
        CompanyService companyService = CompanyService.getInstance();
        DriverService driverService = DriverService.getInstance();

        Company company = new Company("Some Company");
        companyService.saveOneEntity(company);

        Company companyAfterSave = companyService.getOneEntity(1L);

        Driver driver1 = new Driver(1100.0, "Georgi", EDriverQualification.BUS_DRIVERS_LICENSE, companyAfterSave);
        driverService.saveOneEntity(driver1);

        Driver driver2 = new Driver(1200.0, "Ivan", EDriverQualification.TANKER_DRIVERS_LICENSE, companyAfterSave);
        driverService.saveOneEntity(driver2);

        Driver driver3 = new Driver(1300.0, "Aleks", EDriverQualification.BUS_DRIVERS_LICENSE, companyAfterSave);
        driverService.saveOneEntity(driver3);

        Driver driver4 = new Driver(1400.0, "Yordan", EDriverQualification.BUS_DRIVERS_LICENSE, companyAfterSave);
        driverService.saveOneEntity(driver4);

        List<DriverDTO> filteredByQualification = driverService.filterByQualification(EDriverQualification.BUS_DRIVERS_LICENSE);
        System.out.println("\nDrivers filtered by qualification (BUS_DRIVERS_LICENSE):");
        filteredByQualification.forEach(System.out::println);

        List<DriverDTO> sortedBySalary = driverService.sortBySalary();
        System.out.println("\nDrivers sorted by salary:");
        sortedBySalary.forEach(System.out::println);

        List<DriverDTO> filteredBySalary = driverService.filterBySalary(1124.0, 1365.0);
        System.out.println("\nDrivers filtered by salary (between 1124.0 and 1365.0):");
        filteredBySalary.forEach(System.out::println);

        DBUtils.shutdown();
    }

    public static void freightQueriesAndFileExportExample() {
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
        System.out.printf("\nNumber of freights found: %s", freightCount);

        Double freightProfits = freightService.getTotalFreightProfits();
        System.out.printf("\nTotal freights profits are: %s", freightProfits);

        List<FreightDTO> sortedFreights = freightService.getAllFreightsSorted();
        System.out.printf("\nGet all freights sorted by start and end location ascending: %s", sortedFreights);
        sortedFreights.forEach(System.out::println);

        List<FreightDTO> filteredFreights = freightService.filterByLocation("Burgas");
        System.out.printf("\nGet all freights with a start or end location - 'Burgas' : %s", filteredFreights);
        filteredFreights.forEach(System.out::println);

        MasterFileLoader loader = new MasterFileLoader(freightService, "/dev/transport-company");
        try {
            loader.exportFreights();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        DBUtils.shutdown();
    }
}