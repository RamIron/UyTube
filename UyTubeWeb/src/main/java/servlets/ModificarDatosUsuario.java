package servlets;

import publicadores.DtFecha;
import publicadores.DtUsuarioWeb;
import interfaces.IUsuario;
import interfaces.UFactory;

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

@WebServlet(name = "ModificarDatosUsuario", value = "/ModificarDatosUsuario")
public class ModificarDatosUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /////////////WEB SERVICE/////////////////
        publicadores.CUsuarioPublishService service = new publicadores.CUsuarioPublishService();
        publicadores.CUsuarioPublish port = service.getCUsuarioPublishPort();
        //////////FIN WEBSERVICE///////////
        HttpSession s = request.getSession();
        DtUsuarioWeb usrS = (DtUsuarioWeb) s.getAttribute("usuario");
        if (usrS != null){
            String nickname = request.getParameter("nickname");
            String nomU = request.getParameter("nomU");
            String apellido = request.getParameter("apellido");
            String fNac = request.getParameter("fNac");
            String nomC = request.getParameter("nomCan");
            String foto = request.getParameter("foto");
            String desc = request.getParameter("descripcion");
            String categoria = request.getParameter("categoria");

            Boolean publico;
            if(request.getParameter("publico") == null){
                publico = false;
            }else{
                publico = true;
            }

            //CODIGO PARA EXTRAER LA FECHA
            //SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date date = null;
            Calendar cal = Calendar.getInstance();
            try {
                date = new SimpleDateFormat("MM/dd/yyyy").parse(fNac);
                cal.setTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("FechaCompleta: " + fNac);
            DtFecha fecha = new DtFecha();
            fecha.setAnio(cal.get(Calendar.YEAR));
            fecha.setMes(cal.get(Calendar.MONTH));
            fecha.setDia(cal.get(Calendar.DAY_OF_MONTH));
            System.out.println("FechaCompleta en datatype: " + fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAnio());

            //FIN DE CODIGO PARA EXTRAER LA FECHA

            if(port.existeNickname(nickname)) {
                port.modificarInfoUsuario(nomU, apellido, fecha, usrS.getFoto());
                port.modificarInfoCanal(nomC, desc, publico);
                port.modificarCatCanal(nickname, categoria);
            }

            DtUsuarioWeb usr = port.obtenerUsuarioWebNick(nickname);
            s.setAttribute("usuario", usr);
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/module/miPerfil.jsp");
            String message = "DATOS DE USUARIO MODIFICADOS";
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
