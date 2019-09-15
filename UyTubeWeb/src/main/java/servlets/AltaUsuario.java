package servlets;

import interfaces.IUsuario;
import interfaces.UFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(name = "AltaUsuario", value = "/AltaUsuario")
public class AltaUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String nomU = request.getParameter("nomU");
        String apellido = request.getParameter("apellido");
        String fNac = request.getParameter("fNac");
        String pass = request.getParameter("pass");
        String nomC = request.getParameter("nomC");
        String foto = request.getParameter("foto");
        String desc = request.getParameter("descripcion");
        Boolean publico;//TODO ver como se maneja esto
        if(request.getParameter("publico") == null){
            publico = false;
        }else{
            publico = true;
        }
        String categoria = request.getParameter("categoria");

        UFactory fU = UFactory.getInstancia();
        IUsuario iU = fU.getIUsuario();

        Calendar fNac2 = Calendar.getInstance(); //TODO
//        fNac.set((Integer) fAnio.getSelectedItem(), (Integer) fMes.getSelectedItem(), (Integer) fDia.getSelectedItem());
        iU.agregarUsuario(nickname, nomU, apellido, fNac2, email);
        if(!foto.equals("")) {
            iU.modificarImagen(foto);
        }else {
            iU.modificarImagen("src/main/resources/img/default.png");
        }
        iU.modificarContrasena(pass);
        iU.agregarCanal();
        if(!nomC.equals("")) {
            iU.modificarInfoCanal(nomC, desc, publico);
        }else {
            iU.modificarInfoCanal(nickname, desc, publico);
        }
        if(!categoria.equals("")){
            //TODO le agrego categoria
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
