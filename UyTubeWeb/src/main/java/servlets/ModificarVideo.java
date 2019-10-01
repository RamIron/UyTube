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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "ModificarVideo" , value = "/ModificarVideo")
public class ModificarVideo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UFactory uF = UFactory.getInstancia();
        IUsuario iU = uF.getIUsuario();
        VFactory vF = VFactory.getInstancia();
        IVideo iV = vF.getIVideo();

        HttpSession s = request.getSession();
        DtUsuarioWeb usr = (DtUsuarioWeb) s.getAttribute("usuario");

        String nomOriginal = request.getParameter("nomOriginal");
        String nomVideo = request.getParameter("nomVid");
        int duracion = Integer.parseInt(request.getParameter("dur"));
        String url = request.getParameter("url");
        String descripcion = request.getParameter("desc");
        String catVideo = request.getParameter("categoria");
        String fPub = request.getParameter("fPub");
        //CODIGO PARA EXTRAER LA FECHA
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        Calendar cal = Calendar.getInstance();
        try {
            date = sdf.parse(fPub);
            cal.setTime(date);
        } catch (ParseException e) {
            System.out.println("Excepcion: error con la fecha");
        }
        //FIN DE CODIGO PARA EXTRAER LA FECHA

        Boolean publico;
        if(request.getParameter("publico") == null){
            publico = false;
        }else{
            publico = true;
        }
        iV.setUsr(usr.getNickname());
        iV.setVid(nomOriginal);
        iV.modificarInfoVideo(nomVideo, descripcion, cal, duracion, url, publico);
        if(!catVideo.isEmpty()) {
            iV.agregarCategoria(catVideo);
        }
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/index.jsp");
        String message = "Se ha modificado el video <strong>" + nomVideo + "</strong>";
        request.setAttribute("message", message);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}