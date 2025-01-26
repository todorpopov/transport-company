package db.entities.client.dtos;

import java.util.Set;

public class ClientDTO extends AbstractClientDTO {
    private Long id;

    private boolean debtor;

    private Set<ClientCompanyDTO> companies;

    public ClientDTO(String name, boolean debtor, Set<ClientCompanyDTO> companies) {
        super(name);
        this.debtor = debtor;
        this.companies = companies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ClientCompanyDTO> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<ClientCompanyDTO> companies) {
        this.companies = companies;
    }

    public boolean isDebtor() {
        return debtor;
    }

    public void setDebtor(boolean debtor) {
        this.debtor = debtor;
    }
}
