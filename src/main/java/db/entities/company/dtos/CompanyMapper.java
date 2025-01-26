package db.entities.company.dtos;

import db.entities.client.dtos.ClientCompanyDTO;
import db.entities.client.dtos.ClientMapper;
import db.entities.company.Company;
import db.entities.driver.dtos.DriverMapper;
import db.entities.freight.dtos.FreightMapper;
import db.entities.vehicle.dtos.VehicleMapper;
import org.example.Utils;

import java.util.Set;
import java.util.stream.Collectors;

public class CompanyMapper {
    public static CompanyDTO toDTO(Company entity) {
        Set<CompanyDriverDTO> drivers = Utils.streamCheck(entity.getDrivers())
                .map(DriverMapper::toCompanyDriverDTO)
                .collect(java.util.stream.Collectors.toSet());

        Set<CompanyVehicleDTO> vehicles = Utils.streamCheck(entity.getVehicles())
                .map(VehicleMapper::toCompanyVehicleDTO)
                .collect(java.util.stream.Collectors.toSet());

        Set<CompanyFreigthDTO> freights = Utils.streamCheck(entity.getFreights())
                .map(FreightMapper::toCompanyFreigthDTO)
                .collect(Collectors.toSet());

        Set<CompanyClientDTO> clients = Utils.streamCheck(entity.getClients())
                .map(ClientMapper::toCompanyClientDTO)
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

    public static Company toEntityFromCreateDTO(CreateCompanyDTO dto) {
        return new Company(dto.getName());
    }

    public static CreateCompanyDTO toCreateDTO(Company entity) {
        return new CreateCompanyDTO(entity.getName());
    }

    public static ClientCompanyDTO toClientCompanyDTO(Company entity) {
        return new ClientCompanyDTO(entity.getId(), entity.getName());
    }
}
