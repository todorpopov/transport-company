package db.entities.freight.dtos;

import db.entities.freight.EFreightType;
import exceptions.InvalidFreighException;

import java.time.LocalDate;

public class FreightDTO extends AbstractFreightDTO {
    private Long id;

    private String companyName;

    private String driverName;

    public FreightDTO(String startLocation, String endLocation, LocalDate startDate, LocalDate endDate, EFreightType type, Double cargoWeight, Double price, Long id, String companyName, String driverName) throws InvalidFreighException {
        super(startLocation, endLocation, startDate, endDate, type, cargoWeight, price);
        this.id = id;
        this.companyName = companyName;
        this.driverName = driverName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getTypeAsString() {
        return this.getType().toString();
    }
}
