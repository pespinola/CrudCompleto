<%-- 
    Document   : Mensaje
    Created on : 01-oct-2016, 21:14:30
    Author     : Pathy
--%>

<%  
    String mensaje = (String) request.getSession().getAttribute("mensaje");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensajes</title>
    </head>
    <body>
        <h1>Ocurrio lo siguiente: <%=mensaje%></h1>
        <a href="listarUsuario.do">Volver al menú principal</a>
    </body>
</html>
