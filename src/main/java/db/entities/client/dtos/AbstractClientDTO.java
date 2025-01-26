package db.entities.client.dtos;


public abstract class AbstractClientDTO {
    private String name;

    public AbstractClientDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
