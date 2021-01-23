<%-- 
    Document   : calendario
    Created on : 13-ene-2021, 11:44:13
    Author     : danih
--%>

<%@page import="model.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>

    <title>Calendario</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link HREF="<%=request.getContextPath()%>/style_sheet.css" TYPE="text/css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/funciones.js"></script>
    <script src="<%=request.getContextPath()%>/scripts.js"></script>
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
        <h2>CALENDARIO </h2>    
        <div class="calendar">
          <div class="calendar__info">
              <div class="calendar__prev" id="prev-month">&#9664;</div>
              <div class="calendar__month" id="month"></div>
              <div class="calendar__year" id="year"></div>
              <div class="calendar__next" id="next-month">&#9654;</div>
          </div>
      
          <div class="calendar__week">
              <div class="calendar__day calendar__item">L</div>
              <div class="calendar__day calendar__item">M</div>
              <div class="calendar__day calendar__item">X</div>
              <div class="calendar__day calendar__item">J</div>
              <div class="calendar__day calendar__item">V</div>
              <div class="calendar__day calendar__item">S</div>
              <div class="calendar__day calendar__item">D</div>
          </div>
      
          <div class="calendar__dates" id="dates"></div>
      </div>
    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>
  </body>

</html>