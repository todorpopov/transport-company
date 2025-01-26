package db.entities.company.dtos;

public abstract class AbstractCompanyDTO {
    private String name;

    public AbstractCompanyDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
