<%-- 
    Document   : registro_diario
    Created on : 13-ene-2021, 11:46:12
    Author     : danih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    
    <title>Estado</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link href="..\style_sheet.css" rel="stylesheet">

  </head>

  <body>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css%22%3E">

    <h1>LOGO INGENIEROS AL PESO</h1>
    <h2>EMPLEADOS</h2>

    <div class="navbar">
      <a href="<%=request.getContextPath()%>/Empleados/main.jsp"> Inicio </a>
      <a href="<%=request.getContextPath()%>/Empleados/registro_diario.jsp"> Registro diario </a>
      <a href="<%=request.getContextPath()%>/Empleados/proyectos.jsp"> Proyectos </a>
      <a href="<%=request.getContextPath()%>/Empleados/calendario.jsp"> Calendario </a>
      <a href="<%=request.getContextPath()%>/Empleados/estadisticas.jsp"> Estadísticas </a>
      <a href="<%=request.getContextPath()%>/Empleados/solicitudes.jsp"> Solicitudes </a>
    </div>

    <div class="texto1">
        <h2>MARCAJE DIARIO </h2>
        <div class="tool">
        </div>
        <p>Estado de conexión: CONECTADO</p>
        <br><p>
          <img src="logout.png" alt="Conectado" width="65" height="65">
        </p>
        <br><button class="boton">
          <a id="desconectar" onclick="cambiarDesconectar()"> DESCONECTAR </a>
        </button>
    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>
  </body>

</html>