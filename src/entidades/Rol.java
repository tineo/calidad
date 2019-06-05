package entidades;

public class Rol {
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public Rol setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Rol setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
