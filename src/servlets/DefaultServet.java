package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlets.DefaultServet",  urlPatterns = "/")
public class DefaultServet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getSession().getAttribute("user"));
        if( request.getSession().getAttribute("user") == null){
            response.sendRedirect(request.getContextPath() + "/login");
        }else{
            response.sendRedirect(request.getContextPath() + "/dashboard");
        }

    }
}
