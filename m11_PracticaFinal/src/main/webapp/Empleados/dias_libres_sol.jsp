<%-- 
    Document   : dias_libres_sol
    Created on : 13-ene-2021, 11:44:29
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
    <link href="<%=request.getContextPath()%>/style_sheet.css" TYPE="text/css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/funciones.js"></script>
  </head>

  <body>
    <% 
    Trabajador usuario = (Trabajador)request.getSession().getAttribute("usuario");
    %>
    <h1>EMPLEADOS</h1>
    <p>BIENVENIDO! <%=usuario.getNombre()%></p>
    <div class="navbar">
      <a href="<%=request.getContextPath()%>/Empleados/main.jsp"> Inicio </a>
      <a href="<%=request.getContextPath()%>/Empleados/registro_diario.jsp"> Registro diario </a>
      <a href="<%=request.getContextPath()%>/ProyectoController?action=listTrabajadorProyectos"> Proyectos </a>
      <a href="<%=request.getContextPath()%>/CalendarioController?action=calendario"> Calendario </a>
      <a href="<%=request.getContextPath()%>/Empleados/solicitudes.jsp"> Solicitudes </a>
    </div>

    <div class="texto1">
        <h2> SOLICITUD DE DÍAS LIBRES </h2>
        <br><label for="fechaseleccionada">Selecciona el día libre</label>
        <input type="date" id="start" name="fecha" value="2021-01-01" min="2021-01-01" max="2030-12-31"> <br>
        <br><label for="concepto">Indique breve conepto:</label>
        <br><input type="text" id="concepto" name="concepto"> <br>
        <br><button class="boton">
            <a id="solicitarFecha" onclick='location.href="<%=request.getContextPath()%>/PeticionesController?action=solicitarDia&fecha="+document.getElementById("start").value+"&concepto="+document.getElementById("concepto").value'> Solicitar</a>
            </button>
    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>

  </body>

</html>