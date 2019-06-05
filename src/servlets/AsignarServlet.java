package servlets;

import servicios.AsignacionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AsignarServlet",  urlPatterns = "/asignar")
public class AsignarServlet extends HttpServlet {
    AsignacionService asignacionService =  new AsignacionService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curso = request.getParameter("curso");
        String usuario = request.getParameter("usuario");
        String sanio = request.getParameter("anio");
        String ciclo = request.getParameter("ciclo");

        int codigo_id =  Integer.parseInt(curso);
        int usuario_id =  Integer.parseInt(usuario);
        int anio = Integer.parseInt(sanio);
        try {
            asignacionService.asignacion(codigo_id, usuario_id, anio, ciclo);


            response.sendRedirect(request.getContextPath() + "/dashboard");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
