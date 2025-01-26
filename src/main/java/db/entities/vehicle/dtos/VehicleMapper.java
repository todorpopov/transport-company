package db.entities.vehicle.dtos;

import db.entities.company.dtos.CompanyVehicleDTO;
import db.entities.vehicle.Vehicle;

public class VehicleMapper {
    public static VehicleDTO toDTO(Vehicle entity) {
        return new VehicleDTO(
                entity.getType(),
                entity.getId(),
                entity.getCompany().getName()
        );
    }

    public static Vehicle toEntityFromCreateDTO(CreateVehicleDTO createVehicleDto) {
        return new Vehicle(
                createVehicleDto.getType(),
                createVehicleDto.getCompany()
        );
    }

    public static CompanyVehicleDTO toCompanyVehicleDTO(Vehicle entity) {
        return new CompanyVehicleDTO(entity.getId(), entity.getType());
    }
}
