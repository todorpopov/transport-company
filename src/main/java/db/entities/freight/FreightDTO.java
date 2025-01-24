package db.entities.freight;

import db.entities.company.CompanyDTO;
import db.entities.driver.DriverDTO;
import exceptions.InvalidFreighException;

import java.time.LocalDate;

public class FreightDTO {
    private Long id;

    private DriverDTO driver;

    private CompanyDTO company;

    private String startLocation;

    private String endLocation;

    private LocalDate startDate;

    private LocalDate endDate;

    private EFreightType type;

    private Double cargoWeight;

    private Double price;

    public FreightDTO(
            Long id,
            DriverDTO driver,
            CompanyDTO company,
            String startLocation,
            String endLocation,
            LocalDate startDate,
            LocalDate endDate,
            EFreightType type,
            Double cargoWeight,
            Double price
    ) {
        this.id = id;
        this.driver = driver;
        this.company = company;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.cargoWeight = cargoWeight;
        this.price = price;
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
                entity.getCargoWeight(),
                entity.getPrice()
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
                dto.getCargoWeight(),
                dto.getPrice()
        );
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void validateFreight() throws InvalidFreighException {
        if(this.type == EFreightType.CARGO && this.cargoWeight == null) {
            throw new InvalidFreighException("Cargo freights must have weight");
        }

        if(this.type == EFreightType.PEOPLE && this.cargoWeight != null) {
            throw new InvalidFreighException("People freights must not have weight");
        }
    }
}
