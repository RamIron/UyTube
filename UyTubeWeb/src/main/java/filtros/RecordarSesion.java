package filtros;

import publicadores.DtUsuarioWeb;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "RecordarSesion", value = "/*")
public class RecordarSesion implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        publicadores.CUsuarioPublishService service = new publicadores.CUsuarioPublishService();
        publicadores.CUsuarioPublish port = service.getCUsuarioPublishPort();

        HttpSession s = ((HttpServletRequest)req).getSession();
        DtUsuarioWeb usr = (DtUsuarioWeb) s.getAttribute("usuario");
        Cookie[] cookies = ((HttpServletRequest)req).getCookies();
        if (usr == null && cookies != null){
            String selector = "";
            String rawValidator = "";
            for (Cookie aCookie : cookies) {
                if (aCookie.getName().equals("selector")) {
                    selector = aCookie.getValue();
                } else if (aCookie.getName().equals("validator")) {
                    rawValidator = aCookie.getValue();
                }
            }
            if (!"".equals(selector) && !"".equals(rawValidator)) {
                usr = port.obtenerUsuarioConToken(selector,rawValidator);
                if (usr != null){
                    s.setAttribute("usuario", usr);
                }
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
