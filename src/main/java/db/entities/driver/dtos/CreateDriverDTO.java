package db.entities.driver.dtos;

import db.entities.company.Company;
import db.entities.driver.EDriverQualification;


public class CreateDriverDTO extends AbstractDriverDTO {
    private Company company;

    public CreateDriverDTO(String name, EDriverQualification qualification, Company company, Double salary) {
        super(name, qualification, salary);
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
