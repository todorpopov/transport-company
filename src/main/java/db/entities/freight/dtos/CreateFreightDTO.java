package db.entities.freight.dtos;

import db.entities.company.Company;
import db.entities.driver.Driver;
import db.entities.freight.EFreightType;
import exceptions.InvalidFreighException;

import java.time.LocalDate;

public class CreateFreightDTO extends AbstractFreightDTO {
    private Driver driver;

    private Company company;

    public CreateFreightDTO(String startLocation, String endLocation, LocalDate startDate, LocalDate endDate, EFreightType type, Double cargoWeight, Double profit, Driver driver, Company company) throws InvalidFreighException {
        super(startLocation, endLocation, startDate, endDate, type, cargoWeight, profit);
        this.driver = driver;
        this.company = company;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
