package db.entities.driver.dtos;


import db.entities.driver.EDriverQualification;

public abstract class AbstractDriverDTO {
    private String name;

    private EDriverQualification qualification;

    private Double salary;

    public AbstractDriverDTO(String name, EDriverQualification qualification, Double salary) {
        this.name = name;
        this.qualification = qualification;
        this.salary = salary;
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
