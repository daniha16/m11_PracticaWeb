<%-- 
    Document   : registro_diario
    Created on : 13-ene-2021, 11:46:12
    Author     : danih
--%>

<%@page import="model.Trabajador"%>
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

         <h2>MARCAJE DIARIO </h2>
        <div class="tool">
        </div>
        <p>Introduzca la hora de entrada y salida de la empresa</p>
        

            <br><button class="boton">
                <a id="marcarEntrada" onclick='location.href="<%=request.getContextPath()%>/RegistroEmpleadoController?action=entrada"'> MARCAR ENTRADA</a>
                
            </button>
            <br>
            <br><button class="boton">
                <a id="marcarEntrada" onclick='location.href="<%=request.getContextPath()%>/RegistroEmpleadoController?action=salida"'> MARCAR SALIDA</a>
            </button>
        

        <p>Estado de conexión: CONECTADO</p>
        <br><p>
            <img src="logout.png" alt="Conectado" width="65" height="65">
        </p>
        <button class="boton">
          <a id="desconectar" onclick='location.href="<%=request.getContextPath()%>/LoginController?action=Logout"'> DESCONECTAR </a>
        </button>
      </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>
  </body>

</html>