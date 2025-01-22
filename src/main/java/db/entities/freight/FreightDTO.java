package db.entities.freight;

import db.entities.company.CompanyDTO;
import db.entities.driver.DriverDTO;

public class FreightDTO {
    private Long id;

    private DriverDTO driver;

    private CompanyDTO company;

    private String startLocation;

    private String endLocation;

    private java.util.Date startDate;

    private java.util.Date endDate;

    private EFreightType type;

    private Double cargoWeight;

    public FreightDTO(Long id, DriverDTO driver, CompanyDTO company, String startLocation, String endLocation, java.util.Date startDate, java.util.Date endDate, EFreightType type, Double cargoWeight) {
        this.id = id;
        this.driver = driver;
        this.company = company;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.cargoWeight = cargoWeight;
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

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    public EFreightType getType() {
        return type;
    }

    public void setType(EFreightType type) {
        this.type = type;
    }

    public Double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(Double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public static FreightDTO toDTO(Freight entity) {
        return new FreightDTO(
                entity.getId(),
                DriverDTO.toDTO(entity.getDriver()),
                CompanyDTO.toDTO(entity.getCompany()),
                entity.getStartLocation(),
                entity.getEndLocation(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getType(),
                entity.getCargoWeight()
        );
    }

    public static Freight toEntity(FreightDTO dto) {
        return new Freight(
                DriverDTO.toEntity(dto.getDriver()),
                CompanyDTO.toEntity(dto.getCompany()),
                dto.getStartLocation(),
                dto.getEndLocation(),
                dto.getStartDate(),
                dto.getEndDate(),
                dto.getType(),
                dto.getCargoWeight()
        );
    }
}
