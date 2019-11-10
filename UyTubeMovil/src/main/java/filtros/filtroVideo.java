package filtros;

import publicadores.DtElementoWeb;

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
        System.out.println("Id video en filtro: " + idVideo);
        publicadores.CVideoPublishService serviceVideo = new publicadores.CVideoPublishService();
        publicadores.CVideoPublish portVideo = serviceVideo.getCVideoPublishPort();
        DtElementoWeb video = portVideo.obtenerVideo(Integer.parseInt(idVideo));
        if(video != null) {
            //redirecciono a el video
            System.out.println("Toy dentro del if!!!!!!!!!!!!!!!!!!!!!!!_------------------------------");
            RequestDispatcher rd = req.getRequestDispatcher("/module/visualizarVideo.jsp?u=" + video.getNickname() + "&v=" + video.getNombreE());
            rd.forward(req,resp);
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
