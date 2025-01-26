package db.entities.company.dtos;

public class CompanyClientDTO {
    private Long id;

    private String name;

    private boolean debtor;

    public CompanyClientDTO(Long id, String name, boolean debtor) {
        this.id = id;
        this.name = name;
        this.debtor = debtor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDebtor() {
        return debtor;
    }

    public void setDebtor(boolean debtor) {
        this.debtor = debtor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
