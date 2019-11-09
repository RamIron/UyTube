package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CerrarSesion", value = "/CerrarSesion")
public class CerrarSesion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/module/invalido.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        publicadores.CUsuarioPublishService service = new publicadores.CUsuarioPublishService();
        publicadores.CUsuarioPublish port = service.getCUsuarioPublishPort();

        HttpSession s = request.getSession();
        s.removeAttribute("usuario");


        Cookie cookieSelector = new Cookie("selector", "");
        Cookie cookieValidator = new Cookie("validator", "");
        Cookie cookieTipo = new Cookie("tipo", "");
        cookieSelector.setMaxAge(0);
        cookieValidator.setMaxAge(0);
        cookieTipo.setMaxAge(0);
        response.addCookie(cookieSelector);
        response.addCookie(cookieValidator);
        response.addCookie(cookieTipo);

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
