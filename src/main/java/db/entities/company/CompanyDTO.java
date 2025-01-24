package db.entities.company;

import db.entities.client.Client;
import db.entities.client.ClientDTO;
import db.entities.driver.Driver;
import db.entities.driver.DriverDTO;
import db.entities.freight.Freight;
import db.entities.freight.FreightDTO;
import db.entities.vehicle.Vehicle;
import db.entities.vehicle.VehicleDTO;
import org.example.Utils;

import java.util.Set;

public class CompanyDTO {
    private Long id;

    private String name;

    private Set<DriverDTO> drivers;

    private Set<VehicleDTO> vehicles;

    private Set<FreightDTO> freights;

    private Set<ClientDTO> clients;

    public CompanyDTO(
            Long id,
            String name,
            Set<DriverDTO> drivers,
            Set<VehicleDTO> vehicles,
            Set<FreightDTO> freights,
            Set<ClientDTO> clients
    ) {
        this.id = id;
        this.name = name;
        this.drivers = drivers;
        this.vehicles = vehicles;
        this.freights = freights;
        this.clients = clients;
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

    public Set<ClientDTO> getClients() {
        return clients;
    }
    public void setClients(Set<ClientDTO> clients) {
        this.clients = clients;
    }

    public static CompanyDTO toDTO(Company entity) {
        Set<DriverDTO> drivers = Utils.streamCheck(entity.getDrivers())
                .map(DriverDTO::toDTO)
                .collect(java.util.stream.Collectors.toSet());

        Set<VehicleDTO> vehicles = Utils.streamCheck(entity.getVehicles())
                .map(VehicleDTO::toDTO)
                .collect(java.util.stream.Collectors.toSet());

        Set<FreightDTO> freights = Utils.streamCheck(entity.getFreights())
                .map(FreightDTO::toDTO)
                .collect(java.util.stream.Collectors.toSet());

        Set<ClientDTO> clients = Utils.streamCheck(entity.getClients())
                .map(ClientDTO::toDTO)
                .collect(java.util.stream.Collectors.toSet());

        return new CompanyDTO(
                entity.getId(),
                entity.getName(),
                drivers,
                vehicles,
                freights,
                clients
        );
    }

    public static Company toEntity(CompanyDTO dto) {
        Set<Driver> drivers = Utils.streamCheck(dto.getDrivers())
                .map(DriverDTO::toEntity)
                .collect(java.util.stream.Collectors.toSet());

        Set<Vehicle> vehicles = Utils.streamCheck(dto.getVehicles())
                .map(VehicleDTO::toEntity)
                .collect(java.util.stream.Collectors.toSet());

        Set<Freight> freights = Utils.streamCheck(dto.getFreights())
                .map(FreightDTO::toEntity)
                .collect(java.util.stream.Collectors.toSet());

        Set<Client> clients = Utils.streamCheck(dto.getClients())
                .map(ClientDTO::toEntity)
                .collect(java.util.stream.Collectors.toSet());

        return new Company(
                dto.getName(),
                drivers,
                vehicles,
                freights,
                clients
        );
    }
}
