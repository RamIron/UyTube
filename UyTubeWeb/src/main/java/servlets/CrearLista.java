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

@WebServlet(name = "CrearLista", value = "/servlets/CrearLista")
public class CrearLista extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UFactory uF = UFactory.getInstancia();
        IUsuario iU = uF.getIUsuario();
        LRFactory fLr = LRFactory.getInstancia();
        IListaReproduccion iLR = fLr.getIListaReproduccion();

        HttpSession s = request.getSession();
        DtUsuarioWeb usr = (DtUsuarioWeb) s.getAttribute("usuario");

        String nomLista = request.getParameter("nomList");
        Boolean esPublica;//TODO ver como se maneja esto
        if(request.getParameter("esPublica") == null){
            esPublica = false;
        }else{
            esPublica = true;
        }

        if(iLR.existeListaParticular(usr.getNickname(), nomLista)){
            System.out.println("LA LISTA EXISTE");
//           RequestDispatcher rd;
//            rd = request.getRequestDispatcher("/module/nuevaLista.jsp");
//            String message = "EXISTE LA LISTAAAAAAAAAAAAA";
//            request.setAttribute("message", message);
//            rd.forward(request, response);

            String message = "Example source code of Servlet to JSP communication.";
            request.setAttribute("message", message);

            //Servlet JSP communication
            //RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/module/nuevaLista.jsp");

            response.sendRedirect("/module/nuevaLista.jsp");

            //reqDispatcher.forward(request,response);

        } else {
            System.out.println("LA LISTA NO EXISTE");
            iLR.agregarListaParticular(nomLista, esPublica);
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }




    }





    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
