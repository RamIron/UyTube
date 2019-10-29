package servlets;

import publicadores.DtUsuarioWeb;

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
import java.util.GregorianCalendar;

@WebServlet(name = "ComentarVideo", value = "/ComentarVideo")
public class ComentarVideo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uVid = request.getParameter("uVid");
        String nVid = request.getParameter("nVid");
        String comentario = request.getParameter("comentario");
        HttpSession s = request.getSession();
        DtUsuarioWeb usr = (DtUsuarioWeb) s.getAttribute("usuario");
        //WEBSERVICES
        publicadores.CVideoPublishService serviceVideo = new publicadores.CVideoPublishService();
        publicadores.CVideoPublish portVideo = serviceVideo.getCVideoPublishPort();
        //FIN WEBSERVICES
        if (usr != null && uVid != null && nVid != null && comentario != null && !comentario.isEmpty()){
            portVideo.setUsr(uVid);
            portVideo.setVid(nVid);
            XMLGregorianCalendar fPub = null;
            try {
                fPub = getXMLGregorianCalendarNow();
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }
            portVideo.realizarComentario(usr.getNickname(), fPub, comentario);
            String path = "/module/visualizarVideo.jsp?u=" + uVid +"&v=" + nVid;
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
        response.getWriter().append("Parametros invalidos");
    }

    private XMLGregorianCalendar getXMLGregorianCalendarNow()
            throws DatatypeConfigurationException {

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now =
                datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        return now;
    }
}
