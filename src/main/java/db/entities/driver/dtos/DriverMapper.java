package db.entities.driver.dtos;

import db.entities.company.dtos.CompanyDriverDTO;
import db.entities.driver.Driver;
import db.entities.freight.dtos.FreightMapper;
import exceptions.InvalidFreighException;
import org.example.Utils;

import java.util.Set;

public class DriverMapper {
    public static DriverDTO toDTO(Driver entity) {
        Set<DriverFreightDTO> freights = Utils.streamCheck(entity.getFreights())
                .map(freight -> {
                    try {
                        return FreightMapper.toDriverDTO(freight);
                    } catch (InvalidFreighException e) {
                        return null;
                    }
                })
                .collect(java.util.stream.Collectors.toSet());

        return new DriverDTO(
                entity.getId(),
                entity.getName(),
                entity.getQualification(),
                entity.getCompany().getName(),
                entity.getSalary(),
                freights
        );
    }

    public static CreateDriverDTO toCreateDTO(Driver entity) {
        return new CreateDriverDTO(
                entity.getName(),
                entity.getQualification(),
                entity.getCompany(),
                entity.getSalary()
        );
    }

    public static Driver toEntityFromCreateDTO(CreateDriverDTO dto) {
        return new Driver(
                dto.getSalary(),
                dto.getName(),
                dto.getQualification(),
                dto.getCompany()
        );
    }

    public static CompanyDriverDTO toCompanyDriverDTO(Driver entity) {
        return new CompanyDriverDTO(
                entity.getId(),
                entity.getName(),
                entity.getQualification(),
                entity.getSalary()
        );
    }
}
