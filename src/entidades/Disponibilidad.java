package entidades;

public class Disponibilidad {
    private int id;
    private int usuarioId;
    private int categoriaId;
    private int horasDisponibbles;
    private String intervaloDisponibles;

    public int getId() {
        return id;
    }

    public Disponibilidad setId(int id) {
        this.id = id;
        return this;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public Disponibilidad setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public Disponibilidad setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
        return this;
    }

    public int getHorasDisponibbles() {
        return horasDisponibbles;
    }

    public Disponibilidad setHorasDisponibbles(int horasDisponibbles) {
        this.horasDisponibbles = horasDisponibbles;
        return this;
    }

    public String getIntervaloDisponibles() {
        return intervaloDisponibles;
    }

    public Disponibilidad setIntervaloDisponibles(String intervaloDisponibles) {
        this.intervaloDisponibles = intervaloDisponibles;
        return this;
    }
}
