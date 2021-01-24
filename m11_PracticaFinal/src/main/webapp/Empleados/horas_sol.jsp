<%-- 
    Document   : horas_sol
    Created on : 13-ene-2021, 11:45:10
    Author     : danih
--%>

<%@page import="model.Trabajador"%>
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
    <link HREF="<%=request.getContextPath()%>/style_sheet.css" TYPE="text/css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/funciones.js"></script>
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
        <h2> SOLICITUD DE HORAS LIBRES </h2>
        <p>El horario de la oficina es de 08:30h a 18:00h</p>
        <form action="">
          <br><label for="horaseleccionada">Selecciona la hora de salida . . . . .</label>
          <input type="time" id="hora_salida" value="00:00" name="salida-start" min="08:30" max="18:00" required> <br>
          <br><label for="horaseleccionada">Selecciona la hora de entrada . . .</label>
          <input type="time" id="hora_entrada" value="00:00" name="salida-end" min="08:30" max="18:00" required> <br>
          <br><label for="conceptoh">Indique breve conepto:</label>
          <br><input type="text" id="conceptoh" name="conceptoho"> <br>
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