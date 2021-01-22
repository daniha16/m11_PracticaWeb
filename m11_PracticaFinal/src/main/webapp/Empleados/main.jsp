<%-- 
    Document   : main
    Created on : 12-ene-2021, 17:53:10
    Author     : danih
--%>

<%@page import="model.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en"> 
  <head>

    <title>Inicio</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link HREF="<%=request.getContextPath()%>/style_sheet.css" TYPE="text/css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/funciones.js"></script>
  </head>

  <body>
      
    <h1>LOGO INGENIEROS AL PESO</h1>
    <h2>EMPLEADOS</h2>

    <div class="navbar">
      <a href="<%=request.getContextPath()%>/Empleados/main.jsp"> Inicio </a>
      <a href="<%=request.getContextPath()%>/Empleados/registro_diario.jsp"> Registro diario </a>
      <a href="<%=request.getContextPath()%>/ProyectoController?action=listTrabajadorProyectos"> Proyectos </a>
      <a href="<%=request.getContextPath()%>/Empleados/calendario.jsp"> Calendario </a>
      <a href="<%=request.getContextPath()%>/Empleados/solicitudes.jsp"> Solicitudes </a>
    </div>
       
    <%
    Trabajador usuario = (Trabajador)request.getSession().getAttribute("usuario");
    %>
    <p>BIENVENIDO <%=usuario.getNombre()%>! </p>
    <!-- <input type="hidden" name="iden" value="${iden}" /> -->
    <!-- <form  method="GET" id="enviarForm">
        <input type="hidden" name="action" value="" />
        <input type="hidden" name="iden" value="${iden}" />
    </form> -->
    
    <div class="texto1">
        <h2>BIENVENIDO</h2>
        <p>Has iniciado sesión como empleado.</p>
        <p><img src="<%=request.getContextPath()%>/Empleados/logo_inicio.png" alt="logo texto" width="250" height="250"></p>
        <button class="boton">
          <a id="desconectar" onclick='location.href="<%=request.getContextPath()%>/LoginController?action=Logout"'> DESCONECTAR </a>
        </button>
    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>
  </body>

</html>

