package entidades;

public class Curso {
    private int id;
    private String nombre;
    private int escuelaId;

    public int getId() {
        return id;
    }

    public Curso setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Curso setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int getEscuelaId() {
        return escuelaId;
    }

    public Curso setEscuelaId(int escuelaId) {
        this.escuelaId = escuelaId;
        return this;
    }
}
