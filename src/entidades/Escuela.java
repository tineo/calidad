package entidades;

public class Escuela {
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public Escuela setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Escuela setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
