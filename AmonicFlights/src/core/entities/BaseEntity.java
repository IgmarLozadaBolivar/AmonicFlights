package core.entities;

public class BaseEntity {

    private int id;
    private String nombre;

    public BaseEntity() {
    }

    public BaseEntity(int id) {
        this.id = id;
    }

    public BaseEntity(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
