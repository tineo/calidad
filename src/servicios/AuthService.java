package servicios;

import entidades.Usuario;
import util.Conexion;

import java.sql.*;

public class AuthService {

    Connection connection;

    public AuthService() {
        this.connection = Conexion.getConnection();;
    }

    public Usuario login(String codigo, String password) throws SQLException {
        Usuario response =  null;

        String query = "select * from usuario where codigo= ? and clave = ?";

        System.out.println(query);
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, codigo);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();

        while (rs.next())
        {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setCodigo(rs.getString("codigo"));
            usuario.setClave(rs.getString("clave"));
            usuario.setRolId(rs.getInt("rol_id"));
            response = usuario;
        }
        pst.close();
        return response;
    }

}
