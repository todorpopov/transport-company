package db.entities.client;

import db.entities.company.Company;
import db.entities.company.CompanyDTO;
import org.example.Utils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {
    private Long id;

    private final String name;

    private boolean debtor;

    private Set<CompanyDTO> companies;

    public ClientDTO(
            String name,
            boolean debtor,
            Set<CompanyDTO> companies
    ) {
        this.name = name;
        this.debtor = debtor;
        this.companies = companies != null ? companies : new HashSet<>();
    }

    public static ClientDTO toDTO(Client entity) {
        Set<CompanyDTO> companies = Utils.streamCheck(entity.getCompanies())
                .map(CompanyDTO::toDTO)
                .collect(Collectors.toSet());

        return new ClientDTO(
                entity.getName(),
                entity.getDebtor(),
                companies
        );
    }

    public static Client toEntity(ClientDTO dto) {
        Set<Company> companies = Utils.streamCheck(dto.getCompanies())
                .map(CompanyDTO::toEntity)
                .collect(Collectors.toSet());

        return new Client(
                dto.getName(),
                dto.isDebtor(),
                companies
        );
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

    public boolean isDebtor() {
        return debtor;
    }

    public void setDebtor(boolean debtor) {
        this.debtor = debtor;
    }

    public Set<CompanyDTO> getCompanies() {
        return companies;
    }

    public void addCompany(CompanyDTO company) {
        this.companies.add(company);
    }

    public void setCompanies(Set<CompanyDTO> companies) {
        this.companies = companies;
    }
}
