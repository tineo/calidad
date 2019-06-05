package servicios;

import entidades.Curso;
import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DispoService {
    Connection connection;

    public DispoService() {
        connection = Conexion.getConnection();
    }

    public int disponibilidad(int usuario_id, int categoria_id, int horas, String intervalo) throws SQLException {
        int rs = -1;
        String query = "insert into disponibilidad (usuario_id, categoria_id, horas_disponibles, intervalo_disponibles) " +
                " values (?, ?, ?, ?)";

        System.out.println(query);
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1, usuario_id);
        pst.setInt(2, categoria_id);
        pst.setInt(3, horas);
        pst.setString(4, intervalo);
        rs = pst.executeUpdate();

        pst.close();

        return rs;
    }

    public String obtenerInvervalo(int usuarioId) throws SQLException{

        ArrayList lista = new ArrayList();
        String intervalo = "";
        String query = "select d.intervalo_disponibles from disponibilidad d where usuario_id = ?";

        System.out.println(query);
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1, usuarioId);
        ResultSet rs = pst.executeQuery();

        while (rs.next())
        {
            intervalo = (rs.getString("intervalo_disponibles"));
        }
        pst.close();
        return intervalo;

    }

}
