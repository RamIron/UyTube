<%@ page import="interfaces.CFactory" %>
<%@ page import="interfaces.ICategoria" %>
<%@ page import="java.util.List" %>
<%@ page import="datatypes.DtUsuarioWeb" %>
<%@ page import="interfaces.LRFactory" %>
<%@ page import="interfaces.IListaReproduccion" %>
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

<% HttpSession s = request.getSession(); %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>
    UyTube
  </title>
  <!-- Favicon -->
  <link href="./assets/img/brand/favicon.png" rel="icon" type="image/png">
  <!-- Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
  <!-- Icons -->
  <link href="./assets/js/plugins/nucleo/css/nucleo.css" rel="stylesheet" />
  <link href="./assets/js/plugins/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet" />
  <!-- CSS Files -->
  <link href="./assets/css/argon-dashboard.css?v=1.1.0" rel="stylesheet" />
</head>

<body class="">
  <nav class="navbar navbar-vertical fixed-left navbar-expand-md navbar-light bg-white" id="sidenav-main">
    <div class="container-fluid">
      <!-- Toggler -->
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#sidenav-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <!-- Brand -->
      <a class="navbar-brand pt-0" href="./index.jsp">
        <img src="./assets/img/brand/logo.png" class="navbar-brand-img" alt="...">
      </a>
      <!-- User -->
      <ul class="nav align-items-center d-md-none">
        <li class="nav-item dropdown">
          <a class="nav-link" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <div class="media align-items-center">
              <span class="avatar avatar-sm rounded-circle">
                <img alt="Image placeholder" src="./assets/img/theme/team-1-800x800.jpg">
              </span>
            </div>
          </a>
          <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
            <div class=" dropdown-header noti-title">
              <h6 class="text-overflow m-0">Bienvenido</h6>
            </div>
            <a href="./examples/miPerfil.jsp" class="dropdown-item">
              <i class="ni ni-single-02"></i>
              <span>Mi perfil</span>
            </a>
            <div class="dropdown-divider"></div>
            <a href="./CerrarSesion" class="dropdown-item">
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
              <a href="./index.jsp">
                <img src="./assets/img/brand/logo.png">
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
        <form class="mt-4 mb-3 d-md-none" action="./Busqueda" method="get">
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
            <a class="nav-link " href="./module/verUsuarios.jsp">
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
            <a class="nav-link " href="./module/nuevoVideo.jsp">
              <i class="ni ni-fat-add text-blue"></i> Subir video
            </a>
          </li>
          <% } %>
          <li class="nav-item">
            <a class="nav-link " href="./module/verVideos.jsp">
              <i class="ni ni-button-play text-blue"></i> Ver videos
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
            <a class="nav-link " href="./module/nuevaLista.jsp">
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
<%--              <a class="nav-link" href="./ConsultaLista?id=<%=l%>">--%>
                  <a class="nav-link" href="<%= request.getContextPath() %>/module/consultaLista.jsp?id=<%=l%>">
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
        <form class="navbar-search navbar-search-dark form-inline mr-3 d-none d-md-flex ml-lg-auto"  action="./Busqueda" method="get">
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
            <a class="nav-link nav-link-icon" href="./module/registro.jsp">
              <i class="ni ni-circle-08"></i>
              <span class="nav-link-inner--text">Registrarse</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link nav-link-icon" href="./module/iniciarSesion.jsp">
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
                  <img alt="Image placeholder" src="./img/default.png">
                  <% } else { %>
                  <img alt="Image placeholder" src="<%=usr.getFoto()%>">
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
              <a href="./module/miPerfil.jsp" class="dropdown-item">
                <i class="ni ni-single-02"></i>
                <span>Mi perfil</span>
              </a>
              <div class="dropdown-divider"></div>
              <a href="./CerrarSesion" class="dropdown-item">
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
            String message = (String) request.getAttribute("message");
            System.out.println(message);
            if(message != null){
          %>
          <div class="alert alert-success" role="alert">
            <%=message%>
          </div>
          <%}%>
          <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
      </div>
    </div>
    
  </div>
  <!--   Core   -->
  <script src="./assets/js/plugins/jquery/dist/jquery.min.js"></script>
  <script src="./assets/js/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <!--   Optional JS   -->
  <script src="./assets/js/plugins/chart.js/dist/Chart.min.js"></script>
  <script src="./assets/js/plugins/chart.js/dist/Chart.extension.js"></script>
  <!--   Argon JS   -->
  <script src="./assets/js/argon-dashboard.min.js?v=1.1.0"></script>
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