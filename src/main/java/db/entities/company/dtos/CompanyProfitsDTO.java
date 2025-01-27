package db.entities.company.dtos;

public class CompanyProfitsDTO {
    private Long id;

    private String name;

    private Double profits;

    public CompanyProfitsDTO(Long id, String name, Double profits) {
        this.id = id;
        this.name = name;
        this.profits = profits;
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

    public Double getProfits() {
        return profits;
    }

    public void setProfits(Double profits) {
        this.profits = profits;
    }

    @Override
    public String toString() {
        return "CompanyProfitsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profits=" + profits +
                '}';
    }
}
