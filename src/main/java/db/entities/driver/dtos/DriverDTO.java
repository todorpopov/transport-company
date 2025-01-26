package db.entities.driver.dtos;

import db.entities.driver.EDriverQualification;

import java.util.Set;

public class DriverDTO extends AbstractDriverDTO {
    private Long id;

    private String companyName;

    private Set<DriverFreightDTO> freights;

    public DriverDTO(Long id, String name, EDriverQualification qualification, String companyName, Double salary, Set<DriverFreightDTO> freights) {
        super(name, qualification, salary);
        this.id = id;
        this.companyName = companyName;
        this.freights = freights;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<DriverFreightDTO> getFreights() {
        return freights;
    }

    public void setFreights(Set<DriverFreightDTO> freights) {
        this.freights = freights;
    }

    @Override
    public String toString() {
        return "DriverDTO{" +
                "id=" + id +
                ", name='" + this.getName() + '\'' +
                ", qualification='" + this.getQualification().toString() + '\'' +
                ", salary='" + this.getSalary() + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
