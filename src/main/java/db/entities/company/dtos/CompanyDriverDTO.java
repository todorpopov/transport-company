package db.entities.company.dtos;

import db.entities.driver.EDriverQualification;

public class CompanyDriverDTO {
    private Long id;

    private String name;

    private EDriverQualification qualification;

    private Double salary;

    public CompanyDriverDTO(Long id, String name, EDriverQualification qualification, Double salary) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.salary = salary;
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

    public EDriverQualification getQualification() {
        return qualification;
    }

    public void setQualification(EDriverQualification qualification) {
        this.qualification = qualification;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
