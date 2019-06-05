package entidades;

public class Usuario {
    private int id;
    private String codigo;
    private String clave;
    private int rolId;

    public int getId() {
        return id;
    }

    public Usuario setId(int id) {
        this.id = id;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public Usuario setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getClave() {
        return clave;
    }

    public Usuario setClave(String clave) {
        this.clave = clave;
        return this;
    }

    public int getRolId() {
        return rolId;
    }

    public Usuario setRolId(int rolId) {
        this.rolId = rolId;
        return this;
    }
}

