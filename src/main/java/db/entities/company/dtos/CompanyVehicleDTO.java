package db.entities.company.dtos;

import db.entities.vehicle.EVehicleType;

public class CompanyVehicleDTO {
    private Long id;

    private EVehicleType type;

    public CompanyVehicleDTO(Long id, EVehicleType type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EVehicleType getType() {
        return type;
    }

    public void setType(EVehicleType type) {
        this.type = type;
    }
}
