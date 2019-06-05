package entidades;

public class Asignacion {
    private int id;
    private int usuarioId;
    private int cursoId;
    private int anio;
    private String ciclo;

    public int getId() {
        return id;
    }

    public Asignacion setId(int id) {
        this.id = id;
        return this;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public Asignacion setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public int getCursoId() {
        return cursoId;
    }

    public Asignacion setCursoId(int cursoId) {
        this.cursoId = cursoId;
        return this;
    }

    public int getAnio() {
        return anio;
    }

    public Asignacion setAnio(int anio) {
        this.anio = anio;
        return this;
    }

    public String getCiclo() {
        return ciclo;
    }

    public Asignacion setCiclo(String ciclo) {
        this.ciclo = ciclo;
        return this;
    }
}
