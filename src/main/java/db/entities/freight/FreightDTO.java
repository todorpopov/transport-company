package db.entities.freight;

import db.entities.company.CompanyDTO;
import db.entities.driver.DriverDTO;
import exceptions.InvalidFreighException;

import java.time.LocalDate;

public class FreightDTO {
    private Long id;

    private DriverDTO driver;

    private CompanyDTO company;

    private final String startLocation;

    private final String endLocation;

    private final LocalDate startDate;

    private final LocalDate endDate;

    private final EFreightType type;

    private final Double cargoWeight;

    private final Double price;

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
    ) throws InvalidFreighException {
        if (type == EFreightType.CARGO && cargoWeight == null) {
            throw new InvalidFreighException("Cargo freights must have weight");
        }

        if (type == EFreightType.PEOPLE && cargoWeight != null) {
            throw new InvalidFreighException("People freights must not have weight");
        }

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

    public static FreightDTO toDTO(Freight entity) throws InvalidFreighException {
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

    public static Freight toEntity(FreightDTO dto) throws InvalidFreighException {
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

    public DriverDTO getDriver() {
        return driver;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public EFreightType getType() {
        return type;
    }

    public Double getCargoWeight() {
        return cargoWeight;
    }

    public Double getPrice() {
        return price;
    }
}
