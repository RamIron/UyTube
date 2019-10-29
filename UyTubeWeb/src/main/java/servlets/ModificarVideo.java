package servlets;

import publicadores.DtUsuarioWeb;
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
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "ModificarVideo" , value = "/ModificarVideo")
public class ModificarVideo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //WEBSERVICES
        publicadores.CUsuarioPublishService serviceUsuario = new publicadores.CUsuarioPublishService();
        publicadores.CUsuarioPublish portUsuario = serviceUsuario.getCUsuarioPublishPort();

        publicadores.CVideoPublishService serviceVideo = new publicadores.CVideoPublishService();
        publicadores.CVideoPublish portVideo = serviceVideo.getCVideoPublishPort();

        publicadores.CListaRepPublishService serviceListaRep = new publicadores.CListaRepPublishService();
        publicadores.CListaRepPublish portListaRep = serviceListaRep.getCListaRepPublishPort();

        publicadores.CCategoriaPublishService serviceCategoria = new publicadores.CCategoriaPublishService();
        publicadores.CCategoriaPublish portCategoria = serviceCategoria.getCCategoriaPublishPort();
        //FIN WEBSERVICES

        HttpSession s = request.getSession();
        DtUsuarioWeb usr = (DtUsuarioWeb) s.getAttribute("usuario");

        if(usr != null){
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
            XMLGregorianCalendar cal = null;
            try {
                date = sdf.parse(fPub);//TODO nose esta cargando bien la fecha
                System.out.println("FechaCompleta: " + fPub);
                System.out.println("Año: " + date.getYear());
                System.out.println("Mes: " + date.getMonth());
                System.out.println("Dia: " + date.getDay());
                cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(1900 + date.getYear(),date.getMonth(),date.getDay(), 0, 0, 0, 0, -3);
            } catch (DatatypeConfigurationException | ParseException e) {
                e.printStackTrace();
            }
            //FIN DE CODIGO PARA EXTRAER LA FECHA

            Boolean publico;
            if(request.getParameter("publico") == null){
                publico = false;
            }else{
                publico = true;
            }
            portVideo.setUsr(usr.getNickname());
            portVideo.setVid(nomOriginal);
            portVideo.modificarInfoVideo(nomVideo, descripcion, cal, duracion, url, publico);
            if(!catVideo.isEmpty()) {
                portVideo.agregarCategoria(catVideo);
            }
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/index.jsp");
            String message = "Se ha modificado el video <strong>" + nomVideo + "</strong>";
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
