package filtros;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(filterName = "filtroVideo", value = "/v/*")
public class filtroVideo implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String idVideo = ((HttpServletRequest)req).getServletPath().substring(3);
        System.out.println("Id video : " + idVideo);

        if(/* Existe video con ese url*/ false) {
            //redirecciono a el video
        } else {
            //redirecciono a invalido
            RequestDispatcher rd = req.getRequestDispatcher("/module/invalido.jsp");
            rd.forward(req,resp);
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
