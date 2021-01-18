<%-- 
    Document   : peticiones
    Created on : 15-ene-2021, 14:10:43
    Author     : danih
--%>

<%@page import="model.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>peticiones</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link href="<%=request.getContextPath()%>/style_sheet.css" rel="stylesheet">
  </head>
  <body>
    <% 
    Trabajador usuario = (Trabajador)request.getSession().getAttribute("usuario");
    %>
    <h1>LOGO RRHH</h1>
    <h2>Recursos Humanos</h2>
    <p>BIENVENIDO <%=usuario.getNombre()%>! </p>
    <div class="navbar">
      <a href="<%=request.getContextPath()%>/RRHH/main.jsp">Home  </a>
      <a href="<%=request.getContextPath()%>/RRHH/informacion.jsp">Información</a>
      <a href="<%=request.getContextPath()%>/RRHH/peticiones.jsp">Peticiones de Trabajadores</a>
      <a href="<%=request.getContextPath()%>/RRHH/informe.jsp">Solicitar Informe</a>
    </div>


    <div class="texto1">
        <h1>BLA BLA BLA </h1>
        <div class="tool">
        </div>
        <br><p>BLA BLA BLA</p>
        <br><p>&nbsp;&nbsp;&nbsp;BLA BLA BLA</p>
        <br><p>&nbsp;&nbsp;&nbsp;BLA BLA BLA</p>
        <br><p>&nbsp;&nbsp;&nbsp;BLA BLA BLA</p>
        <p>
            <img src=" " alt="logo texto">
        </p>
    </div>


    

  </body>
</html>