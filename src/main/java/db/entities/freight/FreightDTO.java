package db.entities.freight;

import db.entities.company.CompanyDTO;
import db.entities.driver.DriverDTO;

public class FreightDTO {
    private Long id;

    private DriverDTO driver;

    private CompanyDTO company;

    public FreightDTO(Long id, DriverDTO driver, CompanyDTO company) {
        this.id = id;
        this.driver = driver;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DriverDTO getDriver() {
        return driver;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public static FreightDTO toDTO(Freight entity) {
        return new FreightDTO(
                entity.getId(),
                DriverDTO.toDTO(entity.getDriver()),
                CompanyDTO.toDTO(entity.getCompany())
        );
    }

    public static Freight toEntity(FreightDTO dto) {
        return new Freight(
                DriverDTO.toEntity(dto.getDriver()),
                CompanyDTO.toEntity(dto.getCompany())
        );
    }
}
