package db.entities.client.dtos;

import db.entities.client.Client;
import db.entities.company.dtos.CompanyClientDTO;
import db.entities.company.dtos.CompanyMapper;
import org.example.Utils;

import java.util.Set;
import java.util.stream.Collectors;

public class ClientMapper {
    public static ClientDTO toDTO(Client entity) {
        Set<ClientCompanyDTO> clientCompanies = Utils.streamCheck(entity.getCompanies())
                .map(CompanyMapper::toClientCompanyDTO)
                .collect(Collectors.toSet());
        return new ClientDTO(entity.getName(), entity.getDebtor(), clientCompanies);
    }

    public static CreateClientDTO toCreateDTO(Client entity) {
        return new CreateClientDTO(entity.getName(), entity.getDebtor(), entity.getCompanies());
    }

    public static Client toEntityFromCreateDTO(CreateClientDTO dto) {
        return new Client(dto.getName(), dto.isDebtor());
    }

    public static CompanyClientDTO toCompanyClientDTO(Client entity) {
        return new CompanyClientDTO(entity.getId(), entity.getName(), entity.getDebtor());
    }
}
