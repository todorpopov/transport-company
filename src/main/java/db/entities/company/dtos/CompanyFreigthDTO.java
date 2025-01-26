package db.entities.company.dtos;

import db.entities.freight.EFreightType;

import java.time.LocalDate;

public class CompanyFreigthDTO {
    private Long id;

    private Long driverId;

    private String driverName;

    private String startLocation;

    private String endLocation;

    private LocalDate startDate;

    private LocalDate endDate;

    private EFreightType type;

    private Double cargoWeight;

    private Double profit;

    public CompanyFreigthDTO(Long id, Long driverId, String driverName, String startLocation, String endLocation, LocalDate startDate, LocalDate endDate, EFreightType type, Double cargoWeight, Double profit) {
        this.id = id;
        this.driverId = driverId;
        this.driverName = driverName;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.cargoWeight = cargoWeight;
        this.profit = profit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
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

    public Double getProfit() {
        return profit;
    }

    public void setprofit(Double profit) {
        this.profit = profit;
    }
}
