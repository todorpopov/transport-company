package db.entities.company.dtos;

import java.util.HashSet;
import java.util.Set;

public class CompanyDTO extends AbstractCompanyDTO {
    private Long id;

    private Set<CompanyDriverDTO> drivers;

    private Set<CompanyVehicleDTO> vehicles;

    private Set<CompanyFreigthDTO> freights;

    private Set<CompanyClientDTO> clients = new HashSet<>();

    public CompanyDTO(
            Long id,
            String name,
            Set<CompanyDriverDTO> drivers,
            Set<CompanyVehicleDTO> vehicles,
            Set<CompanyFreigthDTO> freights,
            Set<CompanyClientDTO> clients
    ) {
        super(name);
        this.id = id;
        this.drivers = drivers;
        this.vehicles = vehicles;
        this.freights = freights;
        this.clients = clients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CompanyDriverDTO> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<CompanyDriverDTO> drivers) {
        this.drivers = drivers;
    }

    public Set<CompanyVehicleDTO> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<CompanyVehicleDTO> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<CompanyFreigthDTO> getFreights() {
        return freights;
    }

    public void setFreights(Set<CompanyFreigthDTO> freights) {
        this.freights = freights;
    }

    public Set<CompanyClientDTO> getClients() {
        return clients;
    }

    public void setClients(Set<CompanyClientDTO> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", name=" + this.getName() +
                '}';
    }
}
