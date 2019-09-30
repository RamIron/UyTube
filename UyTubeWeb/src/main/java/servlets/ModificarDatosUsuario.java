package servlets;

import datatypes.DtUsuarioWeb;
import interfaces.IUsuario;
import interfaces.UFactory;

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

@WebServlet(name = "ModificarDatosUsuario", value = "/ModificarDatosUsuario")
public class ModificarDatosUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession();
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


        UFactory fU = UFactory.getInstancia();
        IUsuario iU = fU.getIUsuario();


        //CODIGO PARA EXTRAER LA FECHA
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        Calendar cal = Calendar.getInstance();
        try {
            date = sdf.parse(fNac);
            cal.setTime(date);
        } catch (ParseException e) {
            System.out.println("Excepcion: error con la fecha");
        }
        //FIN DE CODIGO PARA EXTRAER LA FECHA

        System.out.println("Nickname: " + nickname);

       if(iU.existeNickname(nickname)) {
           String fotoURL;
           if(!foto.equals("")) {
               fotoURL = "img/usr/" + foto;
           }else {
               fotoURL = "src/main/resources/img/default.png";
           }
            iU.modificarInfoUsuario(nomU, apellido, cal, fotoURL);
            iU.modificarInfoCanal(nomC, desc, publico);
            iU.modificarCatCanal(nickname, categoria);
        }

        DtUsuarioWeb usr = iU.obtenerUsuarioWebNick(nickname);
        s.setAttribute("usuario", usr);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/index.jsp");
        String message = "DATOS DE USUARIO MODIFICADOS";
        request.setAttribute("message", message);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
