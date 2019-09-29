<%@ page import="java.util.List" %>
<%@ page import="datatypes.DtUsuarioWeb" %>
<%@ page import="interfaces.*" %>
<%@ page import="logica.CVideo" %>
<%@ page import="datatypes.DtVideo" %>
<%@ page import="java.sql.SQLOutput" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="datatypes.DtComentario" %>
<%@ page import="datatypes.DtValoracion" %>
<!--

=========================================================
* Argon Dashboard - v1.1.0
=========================================================

* Product Page: https://www.creative-tim.com/product/argon-dashboard
* Copyright 2019 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://github.com/creativetimofficial/argon-dashboard/blob/master/LICENSE.md)

* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<%!

  public String imprimirComentarios(List< DtComentario > comentarios, HttpServletRequest request){
    String res = "";
    if(comentarios.isEmpty()){
      res += "<small>No existen comentarios.</small>";
    }else {
      for (DtComentario c :comentarios){

        Integer dia = c.getFecha().get(Calendar.DAY_OF_MONTH);
        Integer mes = c.getFecha().get(Calendar.MONTH);
        Integer ano = c.getFecha().get(Calendar.YEAR);
        res += "<div class=\"bloque-comentario\">\n" +
                "                      <div>\n" +
                "                        <h5>@" + c.getNickname() + " · " + dia + "/" + mes + "/" + ano + " <button type=\"button\" class=\"btn btn-link\" id=\"btn-" + c.getId() +"\">Responder</button></h5>\n" +
                "                        <small>" + c.getTexto() + "</small>\n" +
                "                      </div>\n" +
                "                      <div id=\"resp-" + c.getId() +"\" class=\"d-none\">\n" +
                "                          <form action=\"" + request.getContextPath() + "/ResponderComentario\" method=\"post\">\n" +
                "                       <div class=\"input-group input-group-alternative\"> \n" +
                "                       <textarea class=\"form-control\" id=\"exampleFormControlTextarea1\" rows=\"3\" placeholder=\"Responder...\" name=\"respuesta\"></textarea>\n" +
                "                       </div>\n" + " <br>\n" +
                "                       <input type=\"hidden\" name=\"id\" value=\"" + c.getId() +"\">\n" +
                "                      <div class=\"float-right\">\n" +
                "                        <button type=\"submit\" class=\"btn btn-primary btn-sm\">Responder</button>\n" +
                "                      </div>\n" +
                "                       <br>\n" +
                "                       </form>\n" +
                "                       </div>"+
                "<script>\n" +
                "                          document.getElementById('btn-" + c.getId() +"').onclick = function(){\n" +
                "                            var $elem = $(\"#resp-" + c.getId() +"\");\n" +
                "                            $elem.removeClass('d-none');\n" +
                "                          }\n" +
                "                        </script>" +
                "                      <br>\n";
        if (!c.getRespuestas().isEmpty()){
          res += "                      <div class=\"container-fluid\">\n" +
                  imprimirComentarios(c.getRespuestas(), request) +
                  "                      </div>";

        }
        res += "                        <hr>\n" +
                "                      </div>";
      }
    }
    return res;
  }

%>

<%HttpSession s = request.getSession();%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>
    UyTube
  </title>
  <!-- Favicon -->
  <link href="<%= request.getContextPath() %>/assets/img/brand/favicon.png" rel="icon" type="image/png">
  <!-- Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
  <!-- Icons -->
  <link href="<%= request.getContextPath() %>/assets/js/plugins/nucleo/css/nucleo.css" rel="stylesheet" />
  <link href="<%= request.getContextPath() %>/assets/js/plugins/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet" />
  <!-- CSS Files -->
  <link href="<%= request.getContextPath() %>/assets/css/argon-dashboard.css?v=1.1.0" rel="stylesheet" />
</head>

<body class="">
  <nav class="navbar navbar-vertical fixed-left navbar-expand-md navbar-light bg-white" id="sidenav-main">
    <div class="container-fluid">
      <!-- Toggler -->
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#sidenav-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <!-- Brand -->
      <a class="navbar-brand pt-0" href="<%= request.getContextPath() %>/index.jsp">
        <img src="<%= request.getContextPath() %>/assets/img/brand/logo.png" class="navbar-brand-img" alt="...">
      </a>
      <!-- User -->
      <ul class="nav align-items-center d-md-none">
        <li class="nav-item dropdown">
          <a class="nav-link" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <div class="media align-items-center">
              <span class="avatar avatar-sm rounded-circle">
                <img alt="Image placeholder" src="<%= request.getContextPath() %>/assets/img/theme/team-1-800x800.jpg">
              </span>
            </div>
          </a>
          <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
            <div class=" dropdown-header noti-title">
              <h6 class="text-overflow m-0">Bienvenido</h6>
            </div>
            <a href="<%= request.getContextPath() %>/module/miPerfil.jsp" class="dropdown-item">
              <i class="ni ni-single-02"></i>
              <span>Mi perfil</span>
            </a>
            <div class="dropdown-divider"></div>
            <a href="<%= request.getContextPath() %>/CerrarSesion" class="dropdown-item">
              <i class="ni ni-user-run"></i>
              <span>Cerrar sesion</span>
            </a>
          </div>
        </li>
      </ul>
      <!-- Collapse -->
      <div class="collapse navbar-collapse" id="sidenav-collapse-main">
        <!-- Collapse header -->
        <div class="navbar-collapse-header d-md-none">
          <div class="row">
            <div class="col-6 collapse-brand">
              <a href="<%= request.getContextPath() %>/index.jsp">
                <img src="<%= request.getContextPath() %>/assets/img/brand/logo.png">
              </a>
            </div>
            <div class="col-6 collapse-close">
              <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#sidenav-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle sidenav">
                <span></span>
                <span></span>
              </button>
            </div>
          </div>
        </div>
        <!-- Form -->
        <form class="mt-4 mb-3 d-md-none" action="<%= request.getContextPath() %>/Busqueda" method="get">
          <div class="input-group input-group-rounded input-group-merge" >
            <input type="search" class="form-control form-control-rounded form-control-prepended" placeholder="Buscar..." aria-label="Search" name="q">
            <div class="input-group-prepend">
              <div class="input-group-text">
                <span class="fa fa-search"></span>
              </div>
            </div>
          </div>
        </form>
        <!-- Navigation -->
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link " href="<%= request.getContextPath() %>/module/verUsuarios.jsp">
              <i class="ni ni-single-02 text-blue"></i> Ver usuarios
            </a>
          </li>
        </ul>
        <!-- Divider -->
        <hr class="my-3">
        <!-- Heading -->
        <h6 class="navbar-heading text-muted">Videos</h6>
        <!-- Navigation -->
        <ul class="navbar-nav">
          <% if (s.getAttribute("usuario") != null){ %>
          <li class="nav-item">
            <a class="nav-link" href="<%= request.getContextPath() %>/module/nuevoVideo.jsp">
              <i class="ni ni-fat-add text-blue"></i> Subir video
            </a>
          </li>
          <% } %>
          <li class="nav-item">
            <a class="nav-link  active" href="<%= request.getContextPath() %>/module/verVideos.jsp">
              <i class="ni ni-button-play text-blue"></i> <strong> Ver videos </strong>
            </a>
          </li>
        </ul>
        <% if (s.getAttribute("usuario") != null){ %>
        <!-- Divider -->
        <hr class="my-3">
        <!-- Heading -->
        <h6 class="navbar-heading text-muted">Listas de Reproduccion</h6>
        <!-- Navigation -->
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link " href="<%= request.getContextPath() %>/module/nuevaLista.jsp">
              <i class="ni ni-fat-add text-blue"></i> Crear lista
            </a>
          </li>
          <%
            LRFactory f = LRFactory.getInstancia();
            IListaReproduccion iL = f.getIListaReproduccion();
            DtUsuarioWeb usr = (DtUsuarioWeb) s.getAttribute("usuario");
            List<String> lis = iL.listarListasDeUsuario(usr.getNickname());
            for(String l: lis){ %>
          <li class="nav-item">
              <a class="nav-link" href="<%= request.getContextPath() %>/ConsultaLista?id=<%=l%>">
                  <i class="ni ni-books text-blue"></i> <%=l%>
              </a>
          </li>
          <% } %>
        </ul>
        <% } %>
        <!-- Divider -->
        <hr class="my-3">
        <!-- Heading -->
        <h6 class="navbar-heading text-muted">Categorias</h6>
        <!-- Navigation -->
        <ul class="navbar-nav">
          <% CFactory fC = CFactory.getInstancia();
            ICategoria iC = fC.getICategoria();
            List<String> lC = iC.listarCategorias();
            for(String cat: lC){ %>
          <li class="nav-item">
            <a class="nav-link" href="<%= request.getContextPath() %>/module/consultaCategoria.jsp?id=<%=cat%>">
              <i class="ni ni-books text-blue"></i> <%=cat%>
            </a>
          </li>
          <% } %>
        </ul>
      </div>
    </div>
  </nav>
  <div class="main-content">
    <!-- Navbar -->
    <nav class="navbar navbar-top navbar-expand-md navbar-dark" id="navbar-main">
      <div class="container-fluid">
        
        <!-- Form - Buscador -->
        <form class="navbar-search navbar-search-dark form-inline mr-3 d-none d-md-flex ml-lg-auto"  action="<%= request.getContextPath() %>/Busqueda" method="get">
          <div class="form-group mb-0">
            <div class="input-group input-group-alternative">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-search"></i></span>
              </div>
              <input class="form-control" placeholder="Buscar" type="text" name="q">
            </div>
          </div>
        </form>
        <!-- User -->
        <% if (s.getAttribute("usuario") == null){ %>
        <ul class="navbar-nav align-items-center d-none d-md-flex">
          <li class="nav-item">
            <a class="nav-link nav-link-icon" href="<%= request.getContextPath() %>/module/registro.jsp">
              <i class="ni ni-circle-08"></i>
              <span class="nav-link-inner--text">Registrarse</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link nav-link-icon" href="<%= request.getContextPath() %>/module/iniciarSesion.jsp">
              <i class="ni ni-key-25"></i>
              <span class="nav-link-inner--text">Iniciar sesion</span>
            </a>
          </li>
        </ul>
        <% }else {
            DtUsuarioWeb usr = (DtUsuarioWeb) s.getAttribute("usuario");%>
        <ul class="navbar-nav align-items-center d-none d-md-flex">
          <li class="nav-item dropdown">
            <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <div class="media align-items-center">
                <span class="avatar avatar-sm rounded-circle">
                  <% if (usr.getFoto().equals("src/main/resources/img/default.png")) {%>
                  <img alt="Image placeholder" src="<%= request.getContextPath() %>/img/default.png">
                  <% } else { %>
                  <img alt="Image placeholder" src="<%= request.getContextPath() %>/<%=usr.getFoto()%>">
                  <% } %>
                </span>
                <div class="media-body ml-2 d-none d-lg-block">
                  <span class="mb-0 text-sm  font-weight-bold">@<%=usr.getNickname() %></span>
                </div>
              </div>
            </a>
            <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
              <div class=" dropdown-header noti-title">
                <h6 class="text-overflow m-0">Bienvenido</h6>
              </div>
              <a href="<%= request.getContextPath() %>/module/miPerfil.jsp" class="dropdown-item">
                <i class="ni ni-single-02"></i>
                <span>Mi perfil</span>
              </a>
              <div class="dropdown-divider"></div>
              <a href="<%= request.getContextPath() %>/CerrarSesion" class="dropdown-item">
                <i class="ni ni-user-run"></i>
                <span>Cerrar sesion</span>
              </a>
            </div>
          </li>
        </ul>
        <% } %>
      </div>
    </nav>
    <!-- End Navbar -->
    <!-- Header -->
    <div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
      <div class="container-fluid">
        <div class="header-body">
          <!-- Contenido aqui TODO-->
          <%
            if(request.getParameter("u") != null && request.getParameter("v") != null){
                String nick = request.getParameter("u");
              System.out.println("nick " + nick);
                String nomVid = request.getParameter("v");
              System.out.println("vid " + nomVid);
                VFactory vF = VFactory.getInstancia();

                IVideo cV = vF.getIVideo();
                cV.setUsr(nick);
                DtVideo infoV = cV.obtenerInfoVideo(nomVid);
                System.out.println("InfoV " + infoV);

          %>
          <div class="container-fluid">
            <div class="row row- justify-content-right">
              <div class="col-sm-9">
                <div class="card bg-secondary shadow ">
                  <div class="card-body px-lg-5 py-lg-5">
                    <div class="embed-responsive embed-responsive-16by9">
                      <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/dQw4w9WgXcQ" allowfullscreen></iframe>
                    </div>
                    <br/>
                    <h1>
                      <%=infoV.getNombre()%>
                      <% if(infoV.getCategoria() != null){ %>
                      <a href="#" class="badge badge-pill badge-primary"><%=infoV.getCategoria()%></a>
                      <%}%>
                    </h1>
                    <div class="row row- justify-content-right">
                      <div class="col-sm-6">
                        <h3>@<%=nick%> | <%=infoV.getfPublicacion().get(Calendar.DAY_OF_MONTH)%>/<%=infoV.getfPublicacion().get(Calendar.MONTH)%>/<%=infoV.getfPublicacion().get(Calendar.YEAR)%> | <%=infoV.getDuracion()%> seg.</h3>
                      </div>
                      <div class="col-sm-6">
                        <div class="float-sm-right d-sm-inline-flex ">
                          <div>
                            <% if (infoV.getPublico()){%>
                            <i class="fas fa-globe"></i><small> Publico</small>
                            <%} else {%>
                            <i class="fas fa-user-lock"></i><small> Privado</small>
                            <%}%>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          </div>
                          <div>
                            <p class="float-sm-right">
                              <a href="<%= request.getContextPath() %>/ValorarVideo?u=<%=nick%>&v=<%=infoV.getNombre()%>&g=si"><i class="fas fa-thumbs-up"></i> <%=cV.cantidadGusta()%></a> | <a href="<%= request.getContextPath() %>/ValorarVideo?u=<%=nick%>&v=<%=infoV.getNombre()%>&g=no"><%=cV.cantidadNoGusta()%> <i class="fas fa-thumbs-down"></i></a>
                              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </p>
                          </div>

                          <%
                            if (s.getAttribute("usuario") != null){
                              System.out.println("-" + s.getAttribute("usuario") + "-");
                              System.out.println("-" + nick + "-");
                              if( ((DtUsuarioWeb) s.getAttribute("usuario")).getNickname().equals(nick)){
                                //TODO
                          %>

                          <div>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn  btn-sm btn-primary " data-toggle="modal" data-target="#valoraciones">
                              Ver valoraciones
                            </button>

                            <!-- Modal -->
                            <div class="modal fade" id="valoraciones" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                              <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                  <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                      <span aria-hidden="true">&times;</span>
                                    </button>
                                  </div>
                                  <div class="modal-body">

                                    <div class="row">
                                      <div class="col-sm-6">
                                        <strong>Me gusta</strong><br>

                                        <%
                                        List<DtValoracion> listaVal = cV.obtenerValoracionVideo();
                                        int i = 0;
                                        for(DtValoracion v: listaVal) {
                                          if(!listaVal.isEmpty()) {
                                            if(v.getGusta()) { %>
                                        <small>@<%=v.getNickname()%></small><br>
                                            <%}
                                          }
                                        }
                                        %>
                                        <div class="d-sm-none">
                                          <hr>
                                        </div>
                                      </div>

                                      <div class="col-sm-6">
                                        <strong>No me gusta</strong><br>
                                        <%
                                          for(DtValoracion v: listaVal) {
                                            if(!listaVal.isEmpty()) {
                                              if(!v.getGusta()) { %>
                                        <small>@<%=v.getNickname()%></small><br>
                                        <%}
                                        }
                                        }
                                        %>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                          <%}%>
                          <div>
                            <div class="dropdown">
                              <button class="btn btn-primary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Agregar a lista
                              </button>
                              <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <%
                                  LRFactory f = LRFactory.getInstancia();
                                  IListaReproduccion iL = f.getIListaReproduccion();
                                  DtUsuarioWeb usr = (DtUsuarioWeb) s.getAttribute("usuario");
                                  List<String> lis = iL.listarListasDeUsuario(usr.getNickname());
                                  for(String l: lis){
                                %>
                                <a class="dropdown-item" href="<%= request.getContextPath() %>/AgregarALista?l=<%=l%>&vu=<%=nick%>&vn=<%=infoV.getNombre()%>"><%=l%></a>
                                <%}%>
                              </div>
                            </div>
                          </div>
                        <% } %>
                        </div>
                      </div>
                    </div>
                    <hr/>
                    <h3>Descripcion</h3>
                    <small><%=infoV.getDescripcion()%></small>
                  </div>
                </div>
                <br/>
                <% if(infoV.getPublico()){ %>
                <div class="card bg-secondary shadow ">
                  <div class="card-body px-lg-5 py-lg-5">
                    <h2>Comentarios</h2>
                    <%=imprimirComentarios(cV.obtenerComentariosVideo(nomVid), request)%>
                    <% if (s.getAttribute("usuario") != null){ %>
                    <form name="comentar" action="<%= request.getContextPath() %>/ComentarVideo" method="post">
                      <div class="input-group input-group-alternative">
                        <textarea class="form-control" id="exampleFormControlTextarea2" rows="3" placeholder="Comentar..." name="comenatrio"></textarea>
                      </div>
                      <br>
                        <div class="float-right">
                          <button type="submit" class="btn btn-primary btn-sm">Comentar</button>
                        </div>
                      <br>
                    </form>
                    <%}%>
                  </div>
                </div>
                <br/>
                <%}%>
              </div>
              <div class="col-sm-3">
                <div class="card bg-secondary shadow ">
                  <div class="card-body px-lg-5 py-lg-5">
                    <h2>Recomendados</h2>

                  </div>
                </div>
              </div>
            </div>
          </div>
          <%}%>

        </div>
      </div>
    </div>
    
  </div>
  <!--   Core   -->
  <script src="<%= request.getContextPath() %>/assets/js/plugins/jquery/dist/jquery.min.js"></script>
  <script src="<%= request.getContextPath() %>/assets/js/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <!--   Optional JS   -->
  <script src="<%= request.getContextPath() %>/assets/js/plugins/chart.js/dist/Chart.min.js"></script>
  <script src="<%= request.getContextPath() %>/assets/js/plugins/chart.js/dist/Chart.extension.js"></script>
  <!--   Argon JS   -->
  <script src="<%= request.getContextPath() %>/assets/js/argon-dashboard.min.js?v=1.1.0"></script>
  <script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
  <script>
    window.TrackJS &&
      TrackJS.install({
        token: "ee6fab19c5a04ac1a32a645abde4613a",
        application: "argon-dashboard-free"
      });
  </script>
</body>

</html>