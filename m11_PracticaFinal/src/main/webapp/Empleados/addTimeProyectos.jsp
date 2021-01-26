<%-- 
    Document   : addTimeProyectos
    Created on : 24-ene-2021, 20:45:48
    Author     : danih
--%>

<%@page import="model.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>

    <title>Proyectos</title>
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
    <h1>EMPLEADOS</h1>
    <p>Usuario: <%=usuario.getNombre()%> </p>
    <div class="navbar">
      <a href="<%=request.getContextPath()%>/Empleados/main.jsp"> Inicio </a>
      <a href="<%=request.getContextPath()%>/Empleados/registro_diario.jsp"> Registro diario </a>
      <a href="<%=request.getContextPath()%>/ProyectoController?action=listTrabajadorProyectos"> Proyectos </a>
      <a href="<%=request.getContextPath()%>/CalendarioController?action=calendario"> Calendario </a>
      <a href="<%=request.getContextPath()%>/Empleados/solicitudes.jsp"> Solicitudes </a>
    </div>

    <div class="texto1">
        <h2> PROYECTOS </h2>
        
        <p>Introduzca el número de horas que ha trabajado en el proyecto:</p>
        <p>Id de Proyecto: <c:out value="${proyecto.id}" /></p>
        <p>Añadir horas: <input type="number" step="0.01" name="addedTime" id="addedTime" size="10"></p>
        <input type="button" onclick ='location.href="<%=request.getContextPath()%>/ProyectoController?action=updateTime&id=<c:out value="${proyecto.id}" />&horas=<c:out value="${proyecto.tiempo}" />&addedTime="+document.getElementById("addedTime").value' value="Añadir">   
        <input type="button" onclick ='location.href="<%=request.getContextPath()%>/ProyectoController?action=listTrabajadorProyectos"' value="Cancelar">

    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>
  </body>

</html>