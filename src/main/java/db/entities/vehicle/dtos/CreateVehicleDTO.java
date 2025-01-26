package db.entities.vehicle.dtos;

import db.entities.company.Company;
import db.entities.vehicle.EVehicleType;

public class CreateVehicleDTO extends AbstractVehicleDTO {
    private Company company;

    public CreateVehicleDTO(EVehicleType type, Company company) {
        super(type);
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
