package db.entities.vehicle;

import db.entities.company.CompanyDTO;

public class VehicleDTO {
    private Long id;

    private EVehicleType type;

    private CompanyDTO company;

    public VehicleDTO(
            Long id,
            EVehicleType type,
            CompanyDTO company
    ) {
        this.id = id;
        this.type = type;
        this.company = company;
    }

    public static VehicleDTO toDTO(Vehicle entity) {
        return new VehicleDTO(
                entity.getId(),
                entity.getType(),
                CompanyDTO.toDTO(entity.getCompany())
        );
    }

    public static Vehicle toEntity(VehicleDTO dto) {
        return new Vehicle(
                dto.getType(),
                CompanyDTO.toEntity(dto.getCompany())
        );
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

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }
}
