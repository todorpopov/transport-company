package db.entities.client;

import db.entities.company.Company;
import jakarta.persistence.*;

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

    @ManyToMany(mappedBy = "clients")
    private Set<Company> companies;

    public Client() {}

    public Client(String name, boolean debtor, Set<Company> companies) {
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

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}
