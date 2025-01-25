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

    @ManyToMany(cascade = CascadeType.PERSIST)
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
        this.companies = companies != null ? companies : new HashSet<Company>();
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

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompany(Company company) {
        this.companies.add(company);
    }
}
