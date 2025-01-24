package db.entities.driver;

import db.entities.company.CompanyDTO;
import db.entities.freight.Freight;
import db.entities.freight.FreightDTO;
import org.example.Utils;

import java.util.Set;

public class DriverDTO {
    private Long id;

    private String name;

    private EDriverQualification qualification;

    private Set<FreightDTO> freights;

    private CompanyDTO company;

    private Double salary;

    public DriverDTO(
            Long id,
            String name,
            EDriverQualification qualification,
            Set<FreightDTO> freights,
            CompanyDTO company,
            Double salary
    ) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.freights = freights;
        this.company = company;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EDriverQualification getQualification() {
        return qualification;
    }

    public void setQualification(EDriverQualification qualification) {
        this.qualification = qualification;
    }

    public Set<FreightDTO> getFreights() {
        return freights;
    }

    public void setFreights(Set<FreightDTO> freights) {
        this.freights = freights;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public static DriverDTO toDTO(Driver entity) {
        Set<FreightDTO> freights = Utils.streamCheck(entity.getFreights())
                .map(FreightDTO::toDTO)
                .collect(java.util.stream.Collectors.toSet());

        return new DriverDTO(
                entity.getId(),
                entity.getName(),
                entity.getQualification(),
                freights,
                CompanyDTO.toDTO(entity.getCompany()),
                entity.getSalary()
        );
    }

    public static Driver toEntity(DriverDTO dto) {
        Set<Freight> freights = Utils.streamCheck(dto.getFreights())
                .map(FreightDTO::toEntity)
                .collect(java.util.stream.Collectors.toSet());

        return new Driver(
                dto.getName(),
                dto.getQualification(),
                freights,
                CompanyDTO.toEntity(dto.getCompany()),
                dto.getSalary()
        );
    }
}
