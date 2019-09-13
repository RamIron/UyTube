import datatypes.DtUsuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "test", value = "/test")
public class test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession();
        if (s.getAttribute("usuario") == null){
            s.setAttribute("usuario", new DtUsuario());
            System.out.println("No Estoy logeado");
        }else {
            System.out.println("Estoy logeado");
        }

        response.getWriter().append("Served at: ").append(request.getContextPath());

    }

}