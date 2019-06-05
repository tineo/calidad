package servicios;

import entidades.Asignacion;
import entidades.Curso;
import util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AsignacionService {

    Connection connection;

    public AsignacionService() {
        connection = Conexion.getConnection();
    }

    public int asignacion(int curso_id, int usuario_id, int anio, String ciclo) throws SQLException {
        int rs = -1;
        String query = "insert into asignacion (curso_id, usuario_id, anio, ciclo) " +
                        " values (?, ?, ?, ?)";

        System.out.println(query);
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1, curso_id);
        pst.setInt(2, usuario_id);
        pst.setInt(3, anio);
        pst.setString(4, ciclo);
        rs = pst.executeUpdate();

        pst.close();

        return rs;
    }

    public ArrayList cursosAsignados(int usuarioId) throws SQLException {
        ArrayList lista = new ArrayList();

        String query = "select c.* from asignacion a " +
                "inner join curso c on c.id = a.curso_id " +
                "where a.usuario_id = ?";

        System.out.println(query);
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1, usuarioId);
        ResultSet rs = pst.executeQuery();

        while (rs.next())
        {
            Curso curso = new Curso();
            curso.setId(rs.getInt("id"));
            curso.setNombre(rs.getString("nombre"));
            lista.add(curso);

            System.out.println(curso.getNombre());
        }
        pst.close();
        return lista;
    }
}
