package servlets;

import publicadores.DtUsuarioWeb;
import interfaces.IVideo;
import interfaces.VFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(name = "ResponderComentario", value = "/ResponderComentario")
public class ResponderComentario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idC = request.getParameter("id");
        String comentario = request.getParameter("respuesta");
        String path = request.getParameter("path");
        HttpSession s = request.getSession();
        DtUsuarioWeb usr = (DtUsuarioWeb) s.getAttribute("usuario");
        VFactory f = VFactory.getInstancia();
        IVideo iV = f.getIVideo();
        System.out.println(idC + comentario + path + usr);
        if (usr != null && idC != null && comentario != null && !comentario.isEmpty()){
            Calendar fPub = Calendar.getInstance();
            iV.responderComentario(Integer.parseInt(idC), usr.getNickname(), fPub, comentario);
            RequestDispatcher rd;
            rd = request.getRequestDispatcher(path);
            String message = "Comentario Agregado";
            request.setAttribute("message", message);
            rd.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/module/invalido.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/module/invalido.jsp");
    }
}
