<%@ page import="datatypes.DtUsuario" %>
<html>
<body>
<h2>Hello World!</h2>
<%if (
        request.getSession().getAttribute("usuario") == null){
        request.setAttribute("usuario", new DtUsuario());
        response.sendRedirect("www.google.com");
%>
<p> no logeado</p>
<%}else{ %>
<p> logeado</p>
<%}%>
</body>
</html>
