package servlets;

import org.apache.commons.lang3.RandomStringUtils;
import publicadores.DtUsuarioWeb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "IniciarSesion", value = "/IniciarSesion")
public class IniciarSesion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        publicadores.CUsuarioPublishService service = new publicadores.CUsuarioPublishService();
        publicadores.CUsuarioPublish port = service.getCUsuarioPublishPort();

        HttpSession s = request.getSession();
        String nick = request.getParameter("nick");
        String pass = request.getParameter("pass");
        Boolean recordar = request.getParameter("recordar") != null;
        System.out.println(recordar);
        Integer valido = port.iniciarSesion(nick, pass);
        if(valido.equals(1)){
            DtUsuarioWeb usr = port.obtenerUsuarioWebNick(nick);
            s.setAttribute("usuario", usr);
            if(recordar){
                String selector = RandomStringUtils.randomAlphanumeric(12);
                String validador =  RandomStringUtils.randomAlphanumeric(64);

                port.crearToken(selector, validador, nick);

                Cookie cookieSelector = new Cookie("selector", selector);
                cookieSelector.setMaxAge(604800);
                Cookie cookieValidator = new Cookie("validator", validador);
                cookieValidator.setMaxAge(604800);

                response.addCookie(cookieSelector);
                response.addCookie(cookieValidator);
            }
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }else if (valido.equals(2)){
            DtUsuarioWeb usr = port.obtenerUsuarioWebEmail(nick);
            s.setAttribute("usuario", usr);
            if(recordar){
                String selector = RandomStringUtils.randomAlphanumeric(12);
                String validador =  RandomStringUtils.randomAlphanumeric(64);

                port.crearToken(selector, validador, usr.getNickname());

                Cookie cookieSelector = new Cookie("selector", selector);
                cookieSelector.setMaxAge(604800);
                Cookie cookieValidator = new Cookie("validator", validador);
                cookieValidator.setMaxAge(604800);

                response.addCookie(cookieSelector);
                response.addCookie(cookieValidator);
            }
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }else {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/module/iniciarSesion.jsp");
            String message = "Los datos ingresados no son correctos";
            request.setAttribute("message", message);
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/module/invalido.jsp");
    }
}
