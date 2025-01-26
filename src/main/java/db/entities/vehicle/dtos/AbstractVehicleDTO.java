package db.entities.vehicle.dtos;

import db.entities.vehicle.EVehicleType;

public abstract class AbstractVehicleDTO {
    private EVehicleType type;

    public AbstractVehicleDTO(EVehicleType type) {
        this.type = type;
    }

    public EVehicleType getType() {
        return type;
    }

    public void setType(EVehicleType type) {
        this.type = type;
    }
}
