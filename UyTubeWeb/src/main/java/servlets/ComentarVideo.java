package servlets;

import datatypes.DtUsuarioWeb;
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

@WebServlet(name = "ComentarVideo", value = "/ComentarVideo")
public class ComentarVideo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uVid = request.getParameter("uVid");
        String nVid = request.getParameter("nVid");
        String comentario = request.getParameter("comentario");
        HttpSession s = request.getSession();
        DtUsuarioWeb usr = (DtUsuarioWeb) s.getAttribute("usuario");
        VFactory f = VFactory.getInstancia();
        IVideo iV = f.getIVideo();
        if (usr != null && uVid != null && nVid != null && comentario != null && !comentario.isEmpty()){
            iV.setUsr(uVid);
            iV.setVid(nVid);
            Calendar fPub = Calendar.getInstance();
            iV.realizarComentario(usr.getNickname(), fPub, comentario);
            String path = "/module/visualizarVideo.jsp?u=" + uVid +"&v=" + nVid;
            RequestDispatcher rd;
            rd = request.getRequestDispatcher(path);
            String message = "Comentario Agregado";
            request.setAttribute("message", message);
            rd.forward(request, response);
        } else {
            response.getWriter().append("Parametros invalidos");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Parametros invalidos");
    }
}
