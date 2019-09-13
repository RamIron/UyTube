package servlets;

import datatypes.DtUsuarioWeb;
import interfaces.IUsuario;
import interfaces.UFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "IniciarSesion", value = "/IniciarSesion")
public class IniciarSesion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UFactory uF = UFactory.getInstancia();
        IUsuario iU = uF.getIUsuario();
        HttpSession s = request.getSession();
        String nick = request.getParameter("nick");
        String pass = request.getParameter("pass");
        Integer valido = iU.iniciarSesion(nick, pass);
        System.out.println("valido: " +  valido);
        if(valido.equals(1)){
            DtUsuarioWeb usr = iU.obtenerUsuarioWebNick(nick);
            s.setAttribute("usuario", usr);
            System.out.println("No Estoy logeado");
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }else if (valido.equals(2)){
            DtUsuarioWeb usr = iU.obtenerUsuarioWebEmail(nick);
            s.setAttribute("usuario", usr);
            System.out.println("No Estoy logeado");
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }else {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("www.google.com");
            rd.forward(request, response);
            System.out.println("Estoy logeado");
        }

    }
}
