package entidades;

public class Trabajador {
    private int id;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private int usuarioId;

    public int getId() {
        return id;
    }

    public Trabajador setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombres() {
        return nombres;
    }

    public Trabajador setNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public Trabajador setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
        return this;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public Trabajador setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
        return this;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public Trabajador setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }
}
