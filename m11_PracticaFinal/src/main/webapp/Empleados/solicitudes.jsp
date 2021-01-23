<%-- 
    Document   : solicitudes
    Created on : 13-ene-2021, 11:46:23
    Author     : danih
--%>

<%@page import="model.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>

    <title>Peticiones</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link HREF="<%=request.getContextPath()%>/style_sheet.css" TYPE="text/css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/funciones.js"></script>
  </head>

  <body>
    <% 
    Trabajador usuario = (Trabajador)request.getSession().getAttribute("usuario");
    %>
    <h1>LOGO INGENIEROS AL PESO</h1>
    <h2>EMPLEADOS</h2>
    <p>Usuario: <%=usuario.getNombre()%> </p>
    <div class="navbar">
      <a href="<%=request.getContextPath()%>/Empleados/main.jsp"> Inicio </a>
      <a href="<%=request.getContextPath()%>/Empleados/registro_diario.jsp"> Registro diario </a>
      <a href="<%=request.getContextPath()%>/ProyectoController?action=listTrabajadorProyectos"> Proyectos </a>
      <a href="<%=request.getContextPath()%>/Empleados/calendario.jsp"> Calendario </a>
      <a href="<%=request.getContextPath()%>/Empleados/solicitudes.jsp"> Solicitudes </a>
    </div>

    <div class="texto1">
        <h2>Peticiones </h2>
        <h3> Dias libres </h2>
        <form action="">
          <br><label for="fechaseleccionada">Selecciona el día libre</label>
          <input type="date" id="start" name="trip-start" value="2021-01-01" min="2021-01-01" max="2030-12-31"> <br>
          <br><label for="conceptoh">Indique breve conepto:</label>
          <br><input type="text" id="conceptoh" name="conceptoho"> <br>
        <b><button class="boton_claro">
          <a id="solicitar_dia"> Día libre </a>
        </button>
        <h3> Horas libres</h2>
        <p>El horario de la oficina es de 08:30h a 18:00h</p>
        <form action="">
          <br><label for="horaseleccionada">Selecciona la hora de salida . . . . .</label>
          <input type="time" id="hora_salida" value="00:00" name="salida-start" min="08:30" max="18:00" required> <br>
          <br><label for="horaseleccionada">Selecciona la hora de entrada . . .</label>
          <input type="time" id="hora_entrada" value="00:00" name="salida-end" min="08:30" max="18:00" required> <br>
          <br><label for="conceptod">Indique breve conepto:</label>
          <br><input type="text" id="conceptod" name="conceptodi"> <br>
        <br><br><button class="boton_claro">
          <a id="solicitar_hora"> Horas libres </a>
        </button>
        <h3> Vacaciones completas </h3>
        <form action="">
          <br><label for="fechaseleccionada">Selecciona el <b>primer</b> día de vacaciones</label>
          <input type="date" id="start" name="trip-start" value="2021-01-01" min="2021-01-01" max="2030-12-31"> <br>
          <br><label for="fechaseleccionada">Selecciona el <b>último</b> día de vacaciones</label>
          <input type="date" id="end" name="trip-start" value="2021-01-01" min="2021-01-01" max="2030-12-31"> <br>
          <br><label for="conceptov">Indique breve conepto:</label>
          <br><input type="text" id="conceptov" name="conceptova"> <br>
          <br><br><button class="boton_claro">
          <a id="solicitar_vacaciones"> Vacaciones </a>
        </button>
        </form> 
    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>
  </body>

</html>