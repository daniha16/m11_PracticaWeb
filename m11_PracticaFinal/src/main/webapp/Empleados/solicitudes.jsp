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
        <h2>Peticiones </h2>
        <h3> Dia libre </h2>
        <b><button class="boton_claro">
          <a  href="dias_libres_sol.jsp"> Día libre </a>
        </button>
        <h3> Horas libres</h2>
        <p>El horario de la oficina es de 08:30h a 18:00h</p>
        <b><button class="boton_claro">
          <a  href="horas_sol.jsp"> Horas libres </a>
        </button>
        <h3> Vacaciones completas </h3>
          <b><button class="boton_claro">
              <a  href="vacaciones_sol.jsp"> Vacaciones </a>
        </button>
        </form> 
    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>
  </body>

</html>