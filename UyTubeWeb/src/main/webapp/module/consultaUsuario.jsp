<%@ page import="java.util.List" %>
<%@ page import="datatypes.DtUsuarioWeb" %>
<%@ page import="datatypes.DtUsuario" %>
<%@ page import="interfaces.*" %>
<%@ page import="datatypes.DtCanal" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput" %>
<%@ page import="datatypes.DtElementoUsuario" %>
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
                    <a class="nav-link" href="<%= request.getContextPath() %>/ConsultaCategoria?id=<%=cat%>">
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

    <%--COPIA--%>
    <div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
        <div class="container-fluid">
            <div class="header-body">
                <div class="row justify-content-center">
                    <div class="col-xl-10 order-xl-1">
                        <div class="card bg-secondary shadow ">
                            <div class="card-body px-lg-5 py-lg-5">
                                <%
                                    String message = (String) request.getAttribute("message");
                                    if(message != null){
                                %>
                                <div class="alert alert-danger" role="alert">
                                    <%=message%>
                                </div>
                                <%}%>
                                <%
                                    String nickUsr =  request.getParameter("nick");
                                    UFactory fU = UFactory.getInstancia();
                                    IUsuario iUsr = fU.getIUsuario();
                                    DtUsuario usuario = iUsr.obtenerInfoUsuario(nickUsr);
                                    DtCanal canal = iUsr.obtenerInfoCanal();
                                    List<String> seguidos = iUsr.listarSeguidos();
                                    List<String> seguidores = iUsr.listarSeguidores();
                                    DtUsuarioWeb usrSession = (DtUsuarioWeb) s.getAttribute("usuario");
                                    List<DtUsuarioWeb> listSeguidores = iUsr.listarNickFotoWeb(seguidores);
                                    List<DtUsuarioWeb> listSeguidos = iUsr.listarNickFotoWeb(seguidos);
                                    //List> DtElementoUsuario
                                %>
                                <div class="row">
                                    <div class="col-4">
                                        <%--Foto de perfil--%>
                                        <div class="row justify-content-center">
                                            <span href="" class="avatar avatar-ramiro-lg rounded-circle">
                                                <% if (usuario.getImagen().equals("src/main/resources/img/default.png")) {%>
                                                    <img alt="Image placeholder" src="<%= request.getContextPath() %>/img/default.png">
                                                <% } else { %>
                                                    <img alt="Image placeholder" src="<%= request.getContextPath() %>/<%=usuario.getImagen()%>">
                                                <% } %>
                                            </span>
                                        </div>
                                        <%--Fin Foto de perfil--%>

                                        <%--Nickname--%>
                                        <div class="row justify-content-center">
                                            <span class="mb-xl-2 font-weight-bold text-xl">@<%=usuario.getNickname() %></span>
                                        </div>
                                        <%--Fin Nickname--%>

                                        <%--Boton seguir usuario--%>
                                        <div class="row justify-content-center mb-xl-3">
                                            <% if(!seguidores.contains(usrSession.getNickname())){ %>
                                            <a class="btn btn-icon btn-3 btn-primary btn-sm" href="<%= request.getContextPath() %>/SeguirUsuario?u=<%=usuario.getNickname()%>">
                                                <span class="btn-inner--icon"><i class="ni ni-curved-next"></i></span>
                                                <span class="btn-inner--text">Seguir</span>
                                            </a>
                                            <% }else{ %>
                                            <a class="btn btn-icon btn-3 btn-secondary btn-sm" href="<%= request.getContextPath() %>/DejarSeguirUsuario?u=<%=usuario.getNickname()%>">
                                                <span class="btn-inner--icon"><i class="ni ni-check-bold"></i></span>
                                                <span class="btn-inner--text">Siguiendo</span>
                                            </a>
                                            <% } %>
                                        </div>
                                        <%--Fin Boton seguir usuario--%>

                                            <%--Nombre--%>
                                            <div class="row justify-content-center px-lg-5 mb-lg-2">
                                                <h5>Nombre: <br><span class="mb-xl-2 font-weight-bold text-xl"><%=usuario.getNombre() %></span></h5>
                                            </div>
                                            <%--Fin Nombre--%>

                                            <%--Apellido--%>
                                            <div class="row justify-content-center px-lg-5 mb-lg-2">
                                                <h5>Apellido:<br> <span class="mb-xl-2 font-weight-bold text-xl"><%=usuario.getApellido() %></span></h5>
                                            </div>
                                            <%--Fin Apellido--%>

                                            <%--Fecha Nacimiento--%>
                                            <div class="row justify-content-center px-lg-5 mb-lg-2">
                                                <%SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                                String fechaS = sdf.format(usuario.getfNac().getTime());%>
                                                <h5>Fecha de Nacimiento: <br><span class="mb-xl-2 font-weight-bold text-x1"><%=fechaS %></span></h5>
                                            </div>
                                            <%--Fin Fecha nacimiento--%>
                                    </div>



                                    <div class="col-8">
                                        <%if(canal.getPublico()){%>
                                        <div class="text-muted text-center mt-2 mb-3">
                                            <h1>Datos del Canal</h1>
                                        </div>

                                        <div class="row justify-content-center px-lg-5 mb-lg-2">
                                            <%--Nombre Canal--%>
                                            <div class="col">
                                                <h5> Nombre:<br><span class="mb-xl-2 font-weight-bold text-xl"><%=canal.getNombre() %></span></h5>
                                            </div>
                                            <%--Fin Nombre Canal--%>

                                            <%--Categoria Canal--%>
                                            <div class="col justify-content-center">
                                                <h5> Categoría:<br><span class="mb-xl-2 font-weight-bold text-xl"><%=canal.getCategoria() %></span></h5>
                                            </div>
                                            <%--Fin Categoria Canal--%>
                                        </div>

                                        <%--Descripcion Canal--%>
                                        <h5> Descripcion: <br><span class="mb-xl-2 font-weight-bold text-x2"><%=canal.getDescripcion() %></span></h5>
                                        <%--Fin Descripcion Canal--%>

                                        <% }else{ %>
                                        <div class="text-muted text-center mt-2 mb-3">
                                            <hr/>
                                            <h2>El canal de este usuario es privado</h2>
                                        </div>
                                        <%}%>
                                    </div>
                                </div>

                                <hr></hr>

                                <div class="nav-wrapper">
                                    <ul class="nav nav-pills nav-fill flex-column flex-md-row" id="tabs-icons-text" role="tablist">
                                        <li class="nav-item">
                                            <a class="nav-link mb-sm-4 mb-md-0 active" id="tabs-icons-text-1-tab" data-toggle="tab" href="#tabs-icons-text-1" role="tab" aria-controls="tabs-icons-text-1" aria-selected="true"><i class="ni ni-cloud-upload-96 mr-2"></i> <%=seguidores.size()%> Seguidores <%--<span class="badge badge-white"><%=seguidores.size()%></span>--%></a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link mb-sm-4 mb-md-0" id="tabs-icons-text-2-tab" data-toggle="tab" href="#tabs-icons-text-2" role="tab" aria-controls="tabs-icons-text-2" aria-selected="false"><i class="ni ni-bell-55 mr-2"></i> <%=seguidos.size()%> Seguidos </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link mb-sm-4 mb-md-0" id="tabs-icons-text-3-tab" data-toggle="tab" href="#tabs-icons-text-3" role="tab" aria-controls="tabs-icons-text-3" aria-selected="false"><i class="fab fa-youtube mr-2"></i>Videos</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link mb-sm-4 mb-md-0" id="tabs-icons-text-4-tab" data-toggle="tab" href="#tabs-icons-text-4" role="tab" aria-controls="tabs-icons-text-4" aria-selected="false"><i class="fas fa-list-ul mr-2"></i>Listas</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="card shadow">
                                    <div class="card-body">
                                        <div class="tab-content" id="myTabContent">

                                            <%--Comienzo muestra seguidores--%>
                                            <div class="tab-pane fade show active" id="tabs-icons-text-1" role="tabpanel" aria-labelledby="tabs-icons-text-1-tab">
                                                <div class="row row- justify-content-right">
                                                    <% for(DtUsuarioWeb u:listSeguidores) { %>
                                                    <div class="col-sm-4">
                                                        <div class="card bg-secondary shadow ">
                                                            <div class="card-body px-lg-5 py-lg-5">
                                                                <a class="" href="<%= request.getContextPath() %>/module/consultaUsuario.jsp?nick=<%=u.getNickname()%>">
                                                                    <div class="media align-items-center">
                                                                        <span class="avatar avatar-lg rounded-circle">
                                                                          <% if (u.getFoto().equals("src/main/resources/img/default.png")) {%>
                                                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/img/default.png">
                                                                          <% } else { %>
                                                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/<%=u.getFoto()%>">
                                                                          <% } %>
                                                                        </span>
                                                                        <div class="media-body">
                                                                            <span class="mb-0 text-lg  font-weight-bold"> @<%=u.getNickname()%></span>
                                                                        </div>
                                                                    </div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                        <br/>
                                                    </div>
                                                    <% } %>
                                                </div>
                                            </div>
                                            <%--Fin muestra seguidores--%>

                                            <%--Comienzo muestra seguidos--%>
                                            <div class="tab-pane fade" id="tabs-icons-text-2" role="tabpanel" aria-labelledby="tabs-icons-text-2-tab">
                                                <div class="row row- justify-content-right">
                                                    <% for(DtUsuarioWeb u:listSeguidos) { %>
                                                    <div class="col-sm-4">
                                                        <div class="card bg-secondary shadow ">
                                                            <div class="card-body px-lg-5 py-lg-5">
                                                                <a class="" href="<%= request.getContextPath() %>/module/consultaUsuario.jsp?nick=<%=u.getNickname()%>">
                                                                    <div class="media align-items-center">
                                                                        <span class="avatar avatar-lg rounded-circle">
                                                                          <% if (u.getFoto().equals("src/main/resources/img/default.png")) {%>
                                                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/img/default.png">
                                                                          <% } else { %>
                                                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/<%=u.getFoto()%>">
                                                                          <% } %>
                                                                        </span>
                                                                        <div class="media-body">
                                                                            <span class="mb-0 text-lg  font-weight-bold"> @<%=u.getNickname()%></span>
                                                                        </div>
                                                                    </div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                        <br/>
                                                    </div>
                                                    <% } %>
                                                </div>
                                            </div>
                                            <%--Fin muestra seguidos--%>

                                            <%--Comienzo muestra videos--%>
                                            <div class="tab-pane fade" id="tabs-icons-text-3" role="tabpanel" aria-labelledby="tabs-icons-text-3-tab">
                                                <div class="row row- justify-content-right">
                                                    <% for(DtUsuarioWeb u:listSeguidos) { %>
                                                    <div class="col-sm-4">
                                                        <div class="card bg-secondary shadow ">
                                                            <div class="card-body px-lg-5 py-lg-5">
                                                                <a class="" href="<%= request.getContextPath() %>/module/consultaUsuario.jsp?nick=<%=u.getNickname()%>">
                                                                    <div class="media align-items-center">
                                                                        <span class="avatar avatar-lg rounded-circle">
                                                                          <% if (u.getFoto().equals("src/main/resources/img/default.png")) {%>
                                                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/img/default.png">
                                                                          <% } else { %>
                                                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/<%=u.getFoto()%>">
                                                                          <% } %>
                                                                        </span>
                                                                        <div class="media-body">
                                                                            <span class="mb-0 text-lg  font-weight-bold"> @<%=u.getNickname()%></span>
                                                                        </div>
                                                                    </div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                        <br/>
                                                    </div>
                                                    <% } %>
                                                </div>
                                            </div>
                                            <%--Fin muestra videos--%>

                                            <%--Comienzo muestra listas--%>
                                            <div class="tab-pane fade" id="tabs-icons-text-4" role="tabpanel" aria-labelledby="tabs-icons-text-4-tab">
                                                <p class="description">Aca van las listas.</p>
                                            </div>
                                            <%--Fin muestra listas--%>

                                        </div>
                                    </div>
                                </div>






                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </div>
        </div>
    </div>
<%--FIN COPIA--%>

<%--ORIGINAL--%>
    <%--<div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
        <div class="container-fluid">
            <div class="header-body">
                <div class="row justify-content-center">
                    <div class="col-xl-10 order-xl-1">
                        <div class="card bg-secondary shadow ">
                            <div class="card-body px-lg-5 py-lg-5">
                                <div class="text-muted text-center mt-2 mb-3">
                                    <h1>Datos del Usuario</h1>
                                </div>
                                <%
                                    String message = (String) request.getAttribute("message");
                                    if(message != null){
                                %>
                                <div class="alert alert-danger" role="alert">
                                    <%=message%>
                                </div>
                                <%}%>
                                <%
                                    String nickUsr =  request.getParameter("nick");
                                    UFactory fU = UFactory.getInstancia();
                                    IUsuario iUsr = fU.getIUsuario();
                                    DtUsuario usuario = iUsr.obtenerInfoUsuario(nickUsr);
                                    DtCanal canal = iUsr.obtenerInfoCanal();
                                    List<String> seguidos = iUsr.listarSeguidos();
                                    List<String> seguidores = iUsr.listarSeguidores();
                                    DtUsuarioWeb usrSession = (DtUsuarioWeb) s.getAttribute("usuario");
                                    List<DtUsuarioWeb> listSeguidores = iUsr.listarNickFotoWeb(seguidores);
                                    List<DtUsuarioWeb> listSeguidos = iUsr.listarNickFotoWeb(seguidos);
                                    //List> DtElementoUsuario
                                %>

                                &lt;%&ndash;Foto de perfil&ndash;%&gt;
                                <div class="row justify-content-center">
                                    <span href="" class="avatar avatar-ramiro-lg rounded-circle">
                                        <% if (usuario.getImagen().equals("src/main/resources/img/default.png")) {%>
                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/img/default.png">
                                        <% } else { %>
                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/<%=usuario.getImagen()%>">
                                        <% } %>
                                    </span>
                                </div>
                                &lt;%&ndash;Fin Foto de perfil&ndash;%&gt;

                                &lt;%&ndash;Nickname&ndash;%&gt;
                                <div class="row justify-content-center">
                                        <span class="mb-xl-2 font-weight-bold text-xl">@<%=usuario.getNickname() %></span>
                                </div>
                                &lt;%&ndash;Fin Nickname&ndash;%&gt;

                                &lt;%&ndash;Boton seguir usuario&ndash;%&gt;
                                <div class="row justify-content-center mb-xl-3">
                                    <% if(!seguidores.contains(usrSession.getNickname())){ %>
                                    <a class="btn btn-icon btn-3 btn-primary btn-sm" href="<%= request.getContextPath() %>/SeguirUsuario?u=<%=usuario.getNickname()%>">
                                        <span class="btn-inner--icon"><i class="ni ni-curved-next"></i></span>
                                        <span class="btn-inner--text">Seguir</span>
                                    </a>
                                    <% }else{ %>
                                    <a class="btn btn-icon btn-3 btn-secondary btn-sm" href="<%= request.getContextPath() %>/DejarSeguirUsuario?u=<%=usuario.getNickname()%>">
                                        <span class="btn-inner--icon"><i class="ni ni-check-bold"></i></span>
                                        <span class="btn-inner--text">Siguiendo</span>
                                    </a>
                                    <% } %>
                                </div>
                                &lt;%&ndash;Fin Boton seguir usuario&ndash;%&gt;

                                <div class="row">
                                    &lt;%&ndash;Nombre&ndash;%&gt;
                                    <div class="col">
                                        <label for="nombreID" > Nombre  </label>
                                        <div class="form-group">
                                            <div class="input-group input-group-alternative">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text"><i class="ni ni-bold-right"></i></span>
                                                </div>
                                                <input name="nomU" class="form-control" placeholder="Nombre" id="nombreID" type="text" value="<%=usuario.getNombre()%>" disabled>
                                            </div>
                                        </div>
                                    </div>
                                    &lt;%&ndash;Fin Nombre&ndash;%&gt;

                                    &lt;%&ndash;Apellido&ndash;%&gt;
                                    <div class="col">
                                        <label for="apellidoID" > Apellido </label>
                                        <div class="form-group">
                                            <div class="input-group input-group-alternative">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text"><i class="ni ni-bold-right"></i></span>
                                                </div>
                                                <input name="apellido" class="form-control" placeholder="Apellido" id="apellidoID" type="text" value="<%=usuario.getApellido()%>" disabled>
                                            </div>
                                        </div>
                                    </div>
                                    &lt;%&ndash;Fin Apellido&ndash;%&gt;
                                </div>

                                &lt;%&ndash;Fecha nacimiento&ndash;%&gt;
                                <div class="row">
                                    <div class="col">
                                        <label for="fnacID" > Fehca de Nacimiento </label>
                                        <div class="form-group">
                                            <div class="input-group input-group-alternative">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text"><i class="ni ni-calendar-grid-58"></i></span>
                                                    <%SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                                        String fechaS = sdf.format(usuario.getfNac().getTime());%>
                                                </div>
                                                <input name="fNac" class="form-control datepicker" placeholder="Fecha de nacimiento" id="fNacID" type="text" value="<%=fechaS%>" disabled>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                &lt;%&ndash;Fin Fecha nacimiento&ndash;%&gt;

                                <%if(canal.getPublico()){%>
                                    <div class="text-muted text-center mt-2 mb-3">
                                        <hr/>
                                        <h1>Datos del Canal</h1>
                                    </div>

                                    <div class="row">
                                        &lt;%&ndash;Nombre Canal&ndash;%&gt;
                                        <div class="col">
                                            <label for="nomCanalID" > Nombre de Canal </label>
                                            <div class="form-group">
                                                <div class="input-group input-group-alternative">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"><i class="ni ni-bold-right"></i></span>
                                                    </div>
                                                    <input name="nomCan" class="form-control" placeholder="Nombre (opcional)" id="nomCanalID" type="text" value=" <%=canal.getNombre()%>" disabled>
                                                </div>
                                            </div>
                                        </div>
                                        &lt;%&ndash;Fin Nombre Canal&ndash;%&gt;

                                        &lt;%&ndash;Categoria Canal&ndash;%&gt;
                                        <div class="col">
                                            <label for="selCategoriaID" > Categoría </label>
                                            <div class="form-group">
                                                <select class="custom-select" id="selCategoriaID" name="categoria" disabled>
                                                    <option value="" <%= (canal.getCategoria().equals("") )? "selected": "" %>> --Sin Categoria-- </option>
                                                    <%for(String cat: lC){ %>
                                                        <option value="<%=cat%>" <%= (canal.getCategoria().equals(cat)) ? "selected" : ""%>><%=cat%></option>
                                                    <% } %>
                                                </select>
                                            </div>
                                        </div>
                                        &lt;%&ndash;Fin Categoria Canal&ndash;%&gt;
                                    </div>

                                    &lt;%&ndash;Descripcion Canal&ndash;%&gt;
                                    <div class="form-group">
                                        <label for="descripCanID" > Descripción de Canal </label>
                                        <div class="input-group input-group-alternative">
                                            <textarea class="form-control" id="descripCanID" rows="3" placeholder="Descripcion..." disabled name="descripcion"><%=canal.getDescripcion()%></textarea>
                                        </div>
                                    </div>
                                    &lt;%&ndash;Fin Descripcion Canal&ndash;%&gt;

                                <% }else{ %>
                                    <div class="text-muted text-center mt-2 mb-3">
                                        <hr/>
                                        <h2>El canal de este usuario es privado</h2>
                                    </div>
                                <%}%>

                                <div class="nav-wrapper">
                                    <ul class="nav nav-pills nav-fill flex-column flex-md-row" id="tabs-icons-text" role="tablist">
                                        <li class="nav-item">
                                            <a class="nav-link mb-sm-4 mb-md-0 active" id="tabs-icons-text-1-tab" data-toggle="tab" href="#tabs-icons-text-1" role="tab" aria-controls="tabs-icons-text-1" aria-selected="true"><i class="ni ni-cloud-upload-96 mr-2"></i> <%=seguidores.size()%> Seguidores &lt;%&ndash;<span class="badge badge-white"><%=seguidores.size()%></span>&ndash;%&gt;</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link mb-sm-4 mb-md-0" id="tabs-icons-text-2-tab" data-toggle="tab" href="#tabs-icons-text-2" role="tab" aria-controls="tabs-icons-text-2" aria-selected="false"><i class="ni ni-bell-55 mr-2"></i> <%=seguidos.size()%> Seguidos </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link mb-sm-4 mb-md-0" id="tabs-icons-text-3-tab" data-toggle="tab" href="#tabs-icons-text-3" role="tab" aria-controls="tabs-icons-text-3" aria-selected="false"><i class="fab fa-youtube mr-2"></i>Videos</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link mb-sm-4 mb-md-0" id="tabs-icons-text-4-tab" data-toggle="tab" href="#tabs-icons-text-4" role="tab" aria-controls="tabs-icons-text-4" aria-selected="false"><i class="fas fa-list-ul mr-2"></i>Listas</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="card shadow">
                                    <div class="card-body">
                                        <div class="tab-content" id="myTabContent">

                                            &lt;%&ndash;Comienzo muestra seguidores&ndash;%&gt;
                                            <div class="tab-pane fade show active" id="tabs-icons-text-1" role="tabpanel" aria-labelledby="tabs-icons-text-1-tab">
                                                <div class="row row- justify-content-right">
                                                    <% for(DtUsuarioWeb u:listSeguidores) { %>
                                                    <div class="col-sm-4">
                                                        <div class="card bg-secondary shadow ">
                                                            <div class="card-body px-lg-5 py-lg-5">
                                                                <a class="" href="<%= request.getContextPath() %>/module/consultaUsuario.jsp?nick=<%=u.getNickname()%>">
                                                                    <div class="media align-items-center">
                                                                        <span class="avatar avatar-lg rounded-circle">
                                                                          <% if (u.getFoto().equals("src/main/resources/img/default.png")) {%>
                                                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/img/default.png">
                                                                          <% } else { %>
                                                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/<%=u.getFoto()%>">
                                                                          <% } %>
                                                                        </span>
                                                                        <div class="media-body">
                                                                            <span class="mb-0 text-lg  font-weight-bold"> @<%=u.getNickname()%></span>
                                                                        </div>
                                                                    </div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                        <br/>
                                                    </div>
                                                    <% } %>
                                                </div>
                                            </div>
                                            &lt;%&ndash;Fin muestra seguidores&ndash;%&gt;

                                            &lt;%&ndash;Comienzo muestra seguidos&ndash;%&gt;
                                            <div class="tab-pane fade" id="tabs-icons-text-2" role="tabpanel" aria-labelledby="tabs-icons-text-2-tab">
                                                <div class="row row- justify-content-right">
                                                    <% for(DtUsuarioWeb u:listSeguidos) { %>
                                                    <div class="col-sm-4">
                                                        <div class="card bg-secondary shadow ">
                                                            <div class="card-body px-lg-5 py-lg-5">
                                                                <a class="" href="<%= request.getContextPath() %>/module/consultaUsuario.jsp?nick=<%=u.getNickname()%>">
                                                                    <div class="media align-items-center">
                                                                        <span class="avatar avatar-lg rounded-circle">
                                                                          <% if (u.getFoto().equals("src/main/resources/img/default.png")) {%>
                                                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/img/default.png">
                                                                          <% } else { %>
                                                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/<%=u.getFoto()%>">
                                                                          <% } %>
                                                                        </span>
                                                                        <div class="media-body">
                                                                            <span class="mb-0 text-lg  font-weight-bold"> @<%=u.getNickname()%></span>
                                                                        </div>
                                                                    </div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                        <br/>
                                                    </div>
                                                    <% } %>
                                                </div>
                                            </div>
                                            &lt;%&ndash;Fin muestra seguidos&ndash;%&gt;

                                            &lt;%&ndash;Comienzo muestra videos&ndash;%&gt;
                                            <div class="tab-pane fade" id="tabs-icons-text-3" role="tabpanel" aria-labelledby="tabs-icons-text-3-tab">
                                                <div class="row row- justify-content-right">
                                                    <% for(DtUsuarioWeb u:listSeguidos) { %>
                                                    <div class="col-sm-4">
                                                        <div class="card bg-secondary shadow ">
                                                            <div class="card-body px-lg-5 py-lg-5">
                                                                <a class="" href="<%= request.getContextPath() %>/module/consultaUsuario.jsp?nick=<%=u.getNickname()%>">
                                                                    <div class="media align-items-center">
                                                                        <span class="avatar avatar-lg rounded-circle">
                                                                          <% if (u.getFoto().equals("src/main/resources/img/default.png")) {%>
                                                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/img/default.png">
                                                                          <% } else { %>
                                                                            <img alt="Image placeholder" src="<%= request.getContextPath() %>/<%=u.getFoto()%>">
                                                                          <% } %>
                                                                        </span>
                                                                        <div class="media-body">
                                                                            <span class="mb-0 text-lg  font-weight-bold"> @<%=u.getNickname()%></span>
                                                                        </div>
                                                                    </div>
                                                                </a>
                                                            </div>
                                                        </div>
                                                        <br/>
                                                    </div>
                                                    <% } %>
                                                </div>
                                            </div>
                                            &lt;%&ndash;Fin muestra videos&ndash;%&gt;

                                            &lt;%&ndash;Comienzo muestra listas&ndash;%&gt;
                                            <div class="tab-pane fade" id="tabs-icons-text-4" role="tabpanel" aria-labelledby="tabs-icons-text-4-tab">
                                                <p class="description">Aca van las listas.</p>
                                            </div>
                                            &lt;%&ndash;Fin muestra listas&ndash;%&gt;

                                        </div>
                                    </div>
                                </div>



                            </div>
                        </div>
                    </div>
                </div>
                <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </div>
        </div>
    </div>--%>

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