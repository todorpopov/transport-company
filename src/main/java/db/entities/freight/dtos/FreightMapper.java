package db.entities.freight.dtos;

import db.entities.company.dtos.CompanyFreigthDTO;
import db.entities.driver.dtos.DriverFreightDTO;
import db.entities.freight.Freight;
import exceptions.InvalidFreighException;

public class FreightMapper {
    public static FreightDTO toDTO(Freight entity) throws InvalidFreighException {
        return new FreightDTO(
                entity.getStartLocation(),
                entity.getEndLocation(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getType(),
                entity.getCargoWeight(),
                entity.getProfit(),
                entity.getId(),
                entity.getCompany().getName(),
                entity.getDriver().getName()
        );
    }


    public static DriverFreightDTO toDriverDTO(Freight entity) throws InvalidFreighException {
        return new DriverFreightDTO(
                entity.getId(),
                entity.getCompany().getName(),
                entity.getStartLocation(),
                entity.getEndLocation(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getType(),
                entity.getCargoWeight(),
                entity.getProfit()
        );
    }

    public static Freight toEntityFromCreateDTO(CreateFreightDTO createFreightDto) {
        try {
            return new Freight(
                    createFreightDto.getDriver(),
                    createFreightDto.getCompany(),
                    createFreightDto.getStartLocation(),
                    createFreightDto.getEndLocation(),
                    createFreightDto.getStartDate(),
                    createFreightDto.getEndDate(),
                    createFreightDto.getType(),
                    createFreightDto.getCargoWeight(),
                    createFreightDto.getProfit()
            );
        } catch (InvalidFreighException e) {
            return null;
        }
    }

    public static CompanyFreigthDTO toCompanyFreigthDTO(Freight freight) {
        return new CompanyFreigthDTO(
                freight.getId(),
                freight.getDriver().getId(),
                freight.getDriver().getName(),
                freight.getStartLocation(),
                freight.getEndLocation(),
                freight.getStartDate(),
                freight.getEndDate(),
                freight.getType(),
                freight.getCargoWeight(),
                freight.getProfit()
        );
    }
}
