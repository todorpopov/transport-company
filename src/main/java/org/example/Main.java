package org.example;

import db.DBUtils;
import db.entities.company.Company;
import db.entities.company.CompanyService;
import db.entities.company.dtos.CompanyDTO;
import db.entities.company.dtos.CompanyProfitsByDateDTO;
import db.entities.company.dtos.CompanyProfitsDTO;
import db.entities.driver.Driver;
import db.entities.driver.DriverService;
import db.entities.driver.EDriverQualification;
import db.entities.driver.dtos.DriverDTO;
import db.entities.driver.dtos.DriverShortDesciptionDTO;
import db.entities.freight.EFreightType;
import db.entities.freight.Freight;
import db.entities.freight.FreightService;
import db.entities.freight.dtos.FreightDTO;
import exceptions.InvalidFreighException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        CompanyService companyService = CompanyService.getInstance();
        FreightService freightService = FreightService.getInstance();
        DriverService driverService = DriverService.getInstance();

        Company company1 = new Company("A Company");
        Company company2 = new Company("B Company");

        companyService.saveOneEntity(company1);
        companyService.saveOneEntity(company2);

        Company company1AfterSave = companyService.getOneEntity(1L);
        Company company2AfterSave = companyService.getOneEntity(2L);

        Driver driver1 = new Driver(1100.0, "Georgi", EDriverQualification.BUS_DRIVERS_LICENSE, company1AfterSave);
        Driver driver2 = new Driver(1200.0, "Ivan", EDriverQualification.TANKER_DRIVERS_LICENSE, company1AfterSave);
        Driver driver3 = new Driver(1300.0, "Aleks", EDriverQualification.BUS_DRIVERS_LICENSE, company2AfterSave);
        Driver driver4 = new Driver(1400.0, "Yordan", EDriverQualification.BUS_DRIVERS_LICENSE, company2AfterSave);

        driverService.saveOneEntity(driver1);
        driverService.saveOneEntity(driver2);
        driverService.saveOneEntity(driver3);
        driverService.saveOneEntity(driver4);

        Driver driver1AfterSave = driverService.getOneEntity(1L);
        Driver driver2AfterSave = driverService.getOneEntity(2L);

        try {
            Freight freight1 = new Freight(
                    driver1AfterSave,
                    company1AfterSave,
                    "Sofia",
                    "Burgas",
                    LocalDate.of(2025, 1, 1),
                    LocalDate.of(2025, 1, 1),
                    EFreightType.PEOPLE,
                    null,
                    1500.0
            );

            Freight freight2 = new Freight(
                    driver1AfterSave,
                    company1AfterSave,
                    "Burgas",
                    "Sofia",
                    LocalDate.of(2025, 1, 1),
                    LocalDate.of(2025, 1, 1),
                    EFreightType.PEOPLE,
                    null,
                    1600.0
            );

            Freight freight3 = new Freight(
                    driver2AfterSave,
                    company2AfterSave,
                    "Sofia",
                    "Rome",
                    LocalDate.of(2025, 1, 2),
                    LocalDate.of(2025, 1, 4),
                    EFreightType.PEOPLE,
                    null,
                    3400.0
            );

            Freight freight4 = new Freight(
                    driver2AfterSave,
                    company2AfterSave,
                    "Rome",
                    "Sofia",
                    LocalDate.of(2025, 1, 7),
                    LocalDate.of(2025, 1, 9),
                    EFreightType.PEOPLE,
                    null,
                    3200.0
            );

            freightService.saveOneEntity(freight1);
            freightService.saveOneEntity(freight2);
            freightService.saveOneEntity(freight3);
            freightService.saveOneEntity(freight4);

        } catch (InvalidFreighException e) {
            System.out.println(e.getMessage());
        }

        List<DriverDTO> filteredByQualification = driverService.filterByQualification(EDriverQualification.BUS_DRIVERS_LICENSE);
        System.out.println("\nDrivers filtered by qualification (BUS_DRIVERS_LICENSE):");
        filteredByQualification.forEach(System.out::println);

        List<DriverDTO> sortedBySalary = driverService.sortBySalary();
        System.out.println("\nDrivers sorted by salary:");
        sortedBySalary.forEach(System.out::println);

        List<DriverDTO> filteredBySalary = driverService.filterBySalary(1124.0, 1365.0);
        System.out.println("\nDrivers filtered by salary (between 1124.0 and 1365.0):");
        filteredBySalary.forEach(System.out::println);

        Map<DriverShortDesciptionDTO, Double> mapOfDriversByTotalProfits = driverService.mapDriversByTotalProfits();
        System.out.println("\nDrivers map by total profit of their freights:");
        mapOfDriversByTotalProfits.forEach((dto, v) -> {
            System.out.println(dto.toString() + " - Total profit: " + v);
        });

        Map<DriverShortDesciptionDTO, Long> mapDriversByFreightCount = driverService.mapDriversByFreightCount();
        System.out.println("\nDrivers map by total count of their freights:");
        mapDriversByFreightCount.forEach((dto, v) -> {
            System.out.println(dto.toString() + " - Total count: " + v);
        });

        List<CompanyDTO> sortedCompanies = companyService.sortAllCompaniesByName();
        System.out.println("\nAll companies sorted by name:");
        sortedCompanies.forEach((dto) -> {
            System.out.println(dto.toString());
        });

        List<CompanyProfitsDTO> sortedCompaniesByProfits = companyService.sortByProfits();
        System.out.println("\nAll companies sorted by profits:");
        sortedCompaniesByProfits.forEach((dto) -> {
            System.out.println(dto.toString());
        });

        List<CompanyProfitsDTO> filteredByProfits = companyService.filterByProfits(3000.0, 5000.0);
        System.out.println("\nCompanies filtered by profits (between 3000 and 5000:");
        filteredByProfits.forEach((dto) -> {
            System.out.println(dto.toString());
        });

        List<CompanyProfitsByDateDTO> filterProfitsByDate = companyService.filterProfitsByDate(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 2, 1));
        System.out.println("\nCompany profits filtered by date (between 2025-01-01 and 2025-02-01:):");
        filterProfitsByDate.forEach((dto) -> {
            System.out.println(dto.toString());
        });

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