package db.entities.vehicle.dtos;

import db.entities.vehicle.EVehicleType;

public class VehicleDTO extends AbstractVehicleDTO {
    private Long id;

    private String companyName;

    public VehicleDTO(EVehicleType type, Long id, String companyName) {
        super(type);
        this.id = id;
        this.companyName = companyName;
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
}
