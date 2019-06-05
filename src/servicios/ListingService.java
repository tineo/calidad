package servicios;

import entidades.Categoria;
import entidades.Curso;
import entidades.Usuario;
import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListingService {
    Connection connection;

    public ListingService() {
        this.connection = Conexion.getConnection();
    }

    public ArrayList listarCategorias() throws SQLException {
        ArrayList lista = new ArrayList();

        String query = "select * from categoria";

        System.out.println(query);
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        while (rs.next())
        {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("id"));
            categoria.setNombre(rs.getString("nombre"));
            lista.add(categoria);
        }
        pst.close();
        return lista;
    }

    public ArrayList listarCursos() throws SQLException {
        ArrayList lista = new ArrayList();

        String query = "select * from curso";

        System.out.println(query);
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        while (rs.next())
        {
            Curso curso = new Curso();
            curso.setId(rs.getInt("id"));
            curso.setNombre(rs.getString("nombre"));
            lista.add(curso);
        }
        pst.close();
        return lista;
    }


}
