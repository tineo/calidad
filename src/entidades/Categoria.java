package entidades;

public class Categoria {
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public Categoria setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Categoria setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
