<%-- 
    Document   : vacaciones_sol
    Created on : 13-ene-2021, 11:46:34
    Author     : danih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>

    <title>Solicitud</title>
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
        <h2> SOLICITUD DE VACACIONES </h2>
        <form action="">
          <br><label for="fechaseleccionada">Selecciona el <b>primer</b> día de vacaciones</label>
          <input type="date" id="start" name="trip-start" value="2021-01-01" min="2021-01-01" max="2030-12-31"> <br>
          <br><label for="fechaseleccionada">Selecciona el <b>último</b> día de vacaciones</label>
          <input type="date" id="end" name="trip-start" value="2021-01-01" min="2021-01-01" max="2030-12-31"> <br>
          <br><button class="boton">
            <a id="solicitar"> SOLICITAR </a>
          </button>
        </form> 
    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>

  </body>

</html>