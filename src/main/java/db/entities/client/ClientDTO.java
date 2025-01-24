package db.entities.client;

import db.entities.company.Company;
import db.entities.company.CompanyDTO;
import org.example.Utils;

import java.util.Set;

public class ClientDTO {
    private Long id;

    private String name;

    private boolean debtor;

    private Set<CompanyDTO> companies;

    public ClientDTO(
            String name,
            boolean debtor,
            Set<CompanyDTO> companies
    ) {
        this.name = name;
        this.debtor = debtor;
        this.companies = companies;
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

    public boolean isDebtor() {
        return debtor;
    }

    public void setDebtor(boolean debtor) {
        this.debtor = debtor;
    }

    public Set<CompanyDTO> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<CompanyDTO> companies) {
        this.companies = companies;
    }

    public static ClientDTO toDTO(Client entity) {
        Set<CompanyDTO> companies = Utils.streamCheck(entity.getCompanies())
                .map(CompanyDTO::toDTO)
                .collect(java.util.stream.Collectors.toSet());

        return new ClientDTO(
                entity.getName(),
                entity.isDebtor(),
                companies
        );
    }

    public static Client toEntity(ClientDTO dto) {
        Set<Company> companies = Utils.streamCheck(dto.getCompanies())
                .map(CompanyDTO::toEntity)
                .collect(java.util.stream.Collectors.toSet());

        return new Client(
                dto.getName(),
                dto.isDebtor(),
                companies
        );
    }
}
