package db.entities.company;

import db.entities.driver.Driver;
import db.entities.driver.DriverDTO;
import db.entities.freight.Freight;
import db.entities.freight.FreightDTO;
import db.entities.vehicle.Vehicle;
import db.entities.vehicle.VehicleDTO;

import java.util.Set;

public class CompanyDTO {
    private Long id;

    private String name;

    private Set<DriverDTO> drivers;

    private Set<VehicleDTO> vehicles;

    private Set<FreightDTO> freights;

    public CompanyDTO(Long id, String name, Set<DriverDTO> drivers, Set<VehicleDTO> vehicles, Set<FreightDTO> freights) {
        this.id = id;
        this.name = name;
        this.drivers = drivers;
        this.vehicles = vehicles;
        this.freights = freights;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDrivers(Set<DriverDTO> drivers) {
        this.drivers = drivers;
    }

    public Set<DriverDTO> getDrivers() {
        return drivers;
    }

    public void setVehicles(Set<VehicleDTO> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<VehicleDTO> getVehicles() {
        return vehicles;
    }

    public void setFreights(Set<FreightDTO> freights) {
        this.freights = freights;
    }

    public Set<FreightDTO> getFreights() {
        return freights;
    }

    public static CompanyDTO toDTO(Company entity) {
        Set<DriverDTO> drivers = entity.getDrivers()
                .stream()
                .map(DriverDTO::toDTO)
                .collect(java.util.stream.Collectors.toSet());

        Set<VehicleDTO> vehicles = entity.getVehicles()
                .stream()
                .map(VehicleDTO::toDTO)
                .collect(java.util.stream.Collectors.toSet());

        Set<FreightDTO> freights = entity.getFreights()
                .stream()
                .map(FreightDTO::toDTO)
                .collect(java.util.stream.Collectors.toSet());

        return new CompanyDTO(
                entity.getId(),
                entity.getName(),
                drivers,
                vehicles,
                freights
        );
    }

    public static Company toEntity(CompanyDTO dto) {
        Set<Driver> drivers = dto.getDrivers()
                .stream()
                .map(DriverDTO::toEntity)
                .collect(java.util.stream.Collectors.toSet());

        Set<Vehicle> vehicles = dto.getVehicles()
                .stream()
                .map(VehicleDTO::toEntity)
                .collect(java.util.stream.Collectors.toSet());

        Set<Freight> freights = dto.getFreights()
                .stream().map(FreightDTO::toEntity)
                .collect(java.util.stream.Collectors.toSet());

        return new Company(
                dto.getName(),
                drivers,
                vehicles,
                freights
        );
    }
}
