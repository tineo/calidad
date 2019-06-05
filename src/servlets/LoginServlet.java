package servlets;

import entidades.Usuario;
import servicios.AuthService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "LoginServlet",  urlPatterns = "/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {


    AuthService authService =  new AuthService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String codigo = request.getParameter("codigo");
        String password = request.getParameter("password");
        System.out.println("login");
        System.out.println(codigo);
        System.out.println(password);
        try {
            Usuario usuario = authService.login(codigo, password);
            if( usuario != null){
                request.getSession().setAttribute("user", usuario);
                response.sendRedirect(request.getContextPath() + "/dashboard");
            }else{
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().setAttribute("emp", "string");

        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }
}
