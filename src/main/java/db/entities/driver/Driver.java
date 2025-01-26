package db.entities.driver;

import db.entities.company.Company;
import db.entities.freight.Freight;
import jakarta.persistence.*;

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

    @OneToMany(mappedBy = "driver", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Freight> freights;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(nullable = false)
    private Double salary;

    public Driver() {
    }

    public Driver(Double salary, String name, EDriverQualification qualification, Company company) {
        this.salary = salary;
        this.name = name;
        this.qualification = qualification;
        this.company = company;
    }

    public Driver(String name, EDriverQualification qualification, Set<Freight> freights, Company company, Double salary) {
        this.name = name;
        this.qualification = qualification;
        this.freights = freights;
        this.company = company;
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Freight> getFreights() {
        return freights;
    }

    public void setFreights(Set<Freight> freights) {
        this.freights = freights;
    }

    public EDriverQualification getQualification() {
        return qualification;
    }

    public void setQualification(EDriverQualification qualification) {
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
