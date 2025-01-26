package db.entities.client.dtos;

import db.entities.company.Company;

import java.util.Set;

public class CreateClientDTO extends AbstractClientDTO {
    private boolean debtor;

    private Set<Company> companies;

    public CreateClientDTO(String name, boolean debtor, Set<Company> companies) {
        super(name);
        this.debtor = debtor;
        this.companies = companies;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public boolean isDebtor() {
        return debtor;
    }

    public void setDebtor(boolean debtor) {
        this.debtor = debtor;
    }
}
