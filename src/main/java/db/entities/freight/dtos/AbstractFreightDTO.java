package db.entities.freight.dtos;

import db.entities.freight.EFreightType;
import exceptions.InvalidFreighException;

import java.time.LocalDate;

public abstract class AbstractFreightDTO {
    private String startLocation;

    private String endLocation;

    private LocalDate startDate;

    private LocalDate endDate;

    private EFreightType type;

    private Double cargoWeight;

    private Double price;

    public AbstractFreightDTO(String startLocation, String endLocation, LocalDate startDate, LocalDate endDate, EFreightType type, Double cargoWeight, Double price) throws InvalidFreighException {
        if (type == EFreightType.CARGO && cargoWeight == null) {
            throw new InvalidFreighException("Cargo freights must have weight");
        }

        if (type == EFreightType.PEOPLE && cargoWeight != null) {
            throw new InvalidFreighException("People freights must not have weight");
        }


        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.cargoWeight = cargoWeight;
        this.price = price;
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
}
