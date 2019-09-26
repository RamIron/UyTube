package servlets;

import datatypes.DtUsuarioWeb;
import interfaces.IUsuario;
import interfaces.IVideo;
import interfaces.UFactory;
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

@WebServlet(name = "CrearVideo", value= "/CrearVideo")
public class CrearVideo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UFactory uF = UFactory.getInstancia();
        IUsuario iU = uF.getIUsuario();
        VFactory vF = VFactory.getInstancia();
        IVideo iV = vF.getIVideo();

        HttpSession s = request.getSession();
        DtUsuarioWeb usr = (DtUsuarioWeb) s.getAttribute("usuario");

        String nomVideo = request.getParameter("nomVid");
        int duracion = Integer.parseInt(request.getParameter("dur"));
        String url = request.getParameter("url");
        String descripcion = request.getParameter("desc");
        String catVideo = request.getParameter("categoria");
        Calendar fechaPublicacion = Calendar.getInstance(); //TODO


        if(iV.existeVideo(usr.getNickname(), nomVideo)){
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/module/nuevoVideo.jsp");
            String message = "EXISTE EL VIDEO";
            request.setAttribute("message", message);
            rd.forward(request, response);
        }else{
            iV.agregarVideo(usr.getNickname(), nomVideo, descripcion, fechaPublicacion, duracion, url);
            iV.agregarCategoria(catVideo);
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/index.jsp");
            String message = "Se ha creado el video <strong>" + nomVideo + "</strong>";
            request.setAttribute("message", message);
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
