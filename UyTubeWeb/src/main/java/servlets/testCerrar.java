package servlets;

import datatypes.DtUsuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "testCerrar", value = "/testCerrar")
public class testCerrar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession();
        if (s.getAttribute("usuario") == null){
            System.out.println("No Estoy logeado");
        }else {
            s.removeAttribute("usuario");
            System.out.println("sesion cerrada");
        }

        response.getWriter().append("Served at: ").append(request.getContextPath());

    }

}