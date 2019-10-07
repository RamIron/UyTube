package servlets;

import datatypes.DtUsuarioWeb;
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
        String nomLista = request.getParameter("id");
        Boolean esPublica;

        if(request.getParameter("esPublica") == null){
            esPublica = false;
        }else{
            esPublica = true;
        }

        iLR.modificarInfoLista(nomLista, esPublica);

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/module/consultaLista.jsp");
        String message = "Cambios realizados";
        request.setAttribute("message", message);
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
