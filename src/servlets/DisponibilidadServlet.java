package servlets;

import servicios.DispoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DisponibilidadServlet", urlPatterns = "/disponibilidad")
public class DisponibilidadServlet extends HttpServlet {
    DispoService dispoService = new DispoService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String categoria = request.getParameter("categoria");
        String shoras = request.getParameter("horas");
        String intervalo = request.getParameter("intervalos");

        int usuario_id =  Integer.parseInt(usuario);
        int categoria_id =  Integer.parseInt(categoria);
        int horas =  Integer.parseInt(shoras);

        try {
            dispoService.disponibilidad(usuario_id,categoria_id,horas,intervalo);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
