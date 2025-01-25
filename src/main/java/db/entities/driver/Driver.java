package db.entities.driver;

import db.entities.company.Company;
import db.entities.freight.Freight;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EDriverQualification qualification;

    @OneToMany(mappedBy = "driver", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<Freight> freights;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(nullable = false)
    private Double salary;

    public Driver() {
    }

    public Driver(String name, EDriverQualification qualification, Set<Freight> freights, Company company, Double salary) {
        this.name = name;
        this.qualification = qualification;
        this.freights = freights != null ? freights : new HashSet<Freight>();
        this.company = company;
        this.salary = salary;
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

    public EDriverQualification getQualification() {
        return qualification;
    }

    public void setQualification(EDriverQualification qualification) {
        this.qualification = qualification;
    }

    public Set<Freight> getFreights() {
        return freights;
    }

    public void addFreight(Freight freight) {
        this.freights.add(freight);
    }

    public void setFreights(Set<Freight> freights) {
        this.freights = freights;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
