package servlets;

import publicadores.DtUsuarioWeb;
import interfaces.IUsuario;
import interfaces.LRFactory;
import interfaces.IListaReproduccion;
import interfaces.UFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "ModificarLista", value = "/ModificarLista")
public class ModificarLista extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LRFactory fLr = LRFactory.getInstancia();
        IListaReproduccion iLR = fLr.getIListaReproduccion();

        //este string esta bien????
        String nomLista = request.getParameter("nomL");
        Boolean esPublica;
        HttpSession s = request.getSession();
        DtUsuarioWeb usr = (DtUsuarioWeb) s.getAttribute("usuario");
        if(usr != null) {
            if (request.getParameter("esPublica") == null) {
                esPublica = false;
            } else {
                esPublica = true;
            }

            iLR.setuList(usr.getNickname());
            iLR.setLista(nomLista);
            iLR.modificarInfoLista(nomLista, esPublica);

            System.out.println("Soy la lista en el servlet: " + nomLista);
            System.out.println("Soy el checkbox en el servlet: " + esPublica);

            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/module/consultaLista.jsp?id=" + nomLista);
            String message = "Cambios realizados";
            request.setAttribute("message", message);
            rd.forward(request, response);
        } else {
//            aca se redirecciona a la pagina de no deberias estar aqui
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
