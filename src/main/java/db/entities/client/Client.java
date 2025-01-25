package db.entities.client;

import db.entities.company.Company;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean debtor;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "client_company",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private Set<Company> companies;

    public Client() {
    }

    public Client(String name, boolean debtor, Set<Company> companies) {
        this.name = name;
        this.debtor = debtor;
        this.companies = companies != null ? companies : new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getDebtor() {
        return debtor;
    }

    public void setDebtor(boolean debtor) {
        this.debtor = debtor;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void addCompany(Company company) {
        this.companies.add(company);
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}
