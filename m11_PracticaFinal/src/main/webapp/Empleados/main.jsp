<%-- 
    Document   : main
    Created on : 12-ene-2021, 17:53:10
    Author     : danih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en"> 
  <head>

    <title>Inicio</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link href="<%=request.getContextPath()%>/style_sheet.css" rel="stylesheet">
  </head>

  <body>

    <h1>LOGO INGENIEROS AL PESO</h1>
    <h2>EMPLEADOS</h2>

    <div class="navbar">
      <a href="main.html"> Inicio </a>
      <a href="registro_diario.html"> Registro diario </a>
      <a href="proyectos.html"> Proyectos </a>
      <a href="calendario.html"> Calendario </a>
      <a href="estadisticas.html"> Estadísticas </a>
      <a href="solicitudes.html"> Solicitudes </a>
    </div>

    <div class="texto1">
        <h2>BIENVENIDO</h2>
        <p>Has iniciado sesión como empleado.</p>
        <p><img src="Empleados/logo_inicio.png" alt="logo texto" width="250" height="250"></p>
    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>
  </body>

</html>

