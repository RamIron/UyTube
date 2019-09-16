<%@ page import="interfaces.CFactory" %>
<%@ page import="interfaces.ICategoria" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 13/09/2019
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>
        UyTube - Registrarse
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

<body class="bg-default">
<div class="main-content">
    <!-- Navbar -->
    <nav class="navbar navbar-top navbar-horizontal navbar-expand-md navbar-dark">
        <div class="container px-4">
            <a class="navbar-brand" href="<%= request.getContextPath() %>/index.jsp">
                <img src="<%= request.getContextPath() %>/assets/img/brand/logo.png" />
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse-main" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbar-collapse-main">
                <!-- Collapse header -->
                <div class="navbar-collapse-header d-md-none">
                    <div class="row">
                        <div class="col-6 collapse-brand">
                            <a href="<%= request.getContextPath() %>/index.jsp">
                                <img src="<%= request.getContextPath() %>/assets/img/brand/blue.png">
                            </a>
                        </div>
                        <div class="col-6 collapse-close">
                            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle sidenav">
                                <span></span>
                                <span></span>
                            </button>
                        </div>
                    </div>
                </div>
                <!-- Navbar items -->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link nav-link-icon" href="<%= request.getContextPath() %>/module/iniciarSesion.jsp">
                            <i class="ni ni-key-25"></i>
                            <span class="nav-link-inner--text">Iniciar sesion</span>
                        </a>
                    </li>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Header -->
    <div class="header bg-gradient-primary py-7 py-lg-8">
        <div class="separator separator-bottom separator-skew zindex-100">
            <svg x="0" y="0" viewBox="0 0 2560 100" preserveAspectRatio="none" version="1.1" xmlns="http://www.w3.org/2000/svg">
                <polygon class="fill-default" points="2560 0 2560 100 0 100"></polygon>
            </svg>
        </div>
    </div>
    <!-- Page content -->
    <div class="container mt--8 pb-5">
        <div class="row justify-content-center">
            <div class="col-xl-10 order-xl-1">
                <div class="card bg-secondary shadow ">
                    <div class="card-body px-lg-5 py-lg-5">
                        <div class="text-muted text-center mt-2 mb-3">
                            <h1>Registrarse</h1>
                            <small>Datos del Usuario</small>
                        </div>
                        <form name="registro" role="form" action="<%= request.getContextPath() %>/AltaUsuario" method="post">
                            <div class="row">
                                <div class="col">
                                    <div class="form-group mb-3">
                                        <div class="input-group input-group-alternative">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="ni ni-circle-08"></i></span>
                                            </div>
                                            <input name="nickname" class="form-control" placeholder="Nickname" type="text">
                                        </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <div class="input-group input-group-alternative">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="ni ni-email-83"></i></span>
                                            </div>
                                            <input name="email" class="form-control" placeholder="ejemplo@email.com" type="email">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <div class="input-group input-group-alternative">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="ni ni-bold-right"></i></span>
                                            </div>
                                            <input name="nomU" class="form-control" placeholder="Nombre" type="text">
                                        </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <div class="input-group input-group-alternative">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="ni ni-bold-right"></i></span>
                                            </div>
                                            <input name="apellido" class="form-control" placeholder="Apellido" type="text">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <div class="input-group input-group-alternative">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                                            </div>
                                            <input name="pass" class="form-control" placeholder="Contrasena" type="password">
                                        </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <div class="input-group input-group-alternative">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                                            </div>
                                            <input name="pass2" class="form-control" placeholder="Repetir contrasena" type="password">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <div class="input-group input-group-alternative">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="ni ni-calendar-grid-58"></i></span>
                                            </div>
                                            <input name="fNac" class="form-control datepicker" placeholder="Fecha de nacimiento" type="text" >
                                        </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <div class="input-group input-group-alternative">
                                            <input type="file" class="custom-file-input" id="inputGroupFile01" name="foto">
                                            <label class="custom-file-label" for="inputGroupFile01">Foto de perfil (opcional)</label>
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <div class="text-muted text-center mt-2 mb-3">
                                <hr/>
                                <small>Datos del Canal</small>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <div class="input-group input-group-alternative">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="ni ni-bold-right"></i></span>
                                            </div>
                                            <input class="form-control" placeholder="Nombre (opcional)" type="text" name="nomC">
                                        </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <select class="custom-select" id="inputGroupSelect01" name="categoria">
                                            <option value="" selected> --Sin Categoria-- </option>
                                            <% CFactory fC = CFactory.getInstancia();
                                                ICategoria iC = fC.getICategoria();
                                                List<String> lC = iC.listarCategorias();
                                                for(String cat: lC){ %>
                                            <option value="<%=cat%>"><%=cat%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="input-group input-group-alternative">
                                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Descripcion..." name="descripcion"></textarea>
                                </div>
                            </div>
                            <div class="text-muted text-center mt-2 mb-3">
                                <div class="custom-control custom-control-alternative custom-checkbox mb-3">
                                    <input class="custom-control-input" id="customCheck5" type="checkbox" name="publico">
                                    <label class="custom-control-label" for="customCheck5">Canal publico</label>
                                </div>
                            </div>


                            <div class="text-center">
                                <button type="button" class="btn btn-primary my-4" onclick="continuar()">Continuar registro</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <footer class="py-5">
        <div class="container">

        </div>
    </footer>
</div>
<!--   Core   -->
<script src="<%= request.getContextPath() %>/assets/js/plugins/jquery/dist/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!--   Optional JS   -->
<script src="<%= request.getContextPath() %>/assets/js/plugins/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
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

<script type="text/javascript">
    function continuar() {
        var nick = document.forms["registro"]["nickname"].value;
        var email = document.forms["registro"]["email"].value;
        var nomU = document.forms["registro"]["nomU"].value;
        var apellido = document.forms["registro"]["apellido"].value;
        var fNac = document.forms["registro"]["fNac"].value;
        var pass = document.forms["registro"]["pass"].value;
        var pass2 = document.forms["registro"]["pass2"].value;
        var descripcion = document.forms["registro"]["descripcion"].value;
        if(nick == "" || email == "" || nomU == "" || apellido == "" || fNac == "" || pass == "" || pass2 == "" || descripcion == "" ){
            alert("Falta completar campos");

        } else if (pass != pass2) {
            alert("las contraseñas no coinciden");
        }else {
            document.forms[0].submit();
        }

    }
</script>
</body>

</html>
