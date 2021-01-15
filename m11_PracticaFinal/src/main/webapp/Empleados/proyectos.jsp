<%-- 
    Document   : proyectos
    Created on : 13-ene-2021, 11:45:49
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
    <h1>LOGO INGENIEROS AL PESO</h1>
    <h2>EMPLEADOS</h2>
    <p>Usuario: <%=usuario.getNombre()%> </p>
    <div class="navbar">
      <a href="<%=request.getContextPath()%>/Empleados/main.jsp"> Inicio </a>
      <a href="<%=request.getContextPath()%>/Empleados/registro_diario.jsp"> Registro diario </a>
      <a href="<%=request.getContextPath()%>/ProyectoController?action=listTrabajadorProyectos"> Proyectos </a>
      <a href="<%=request.getContextPath()%>/Empleados/calendario.jsp"> Calendario </a>
      <a href="<%=request.getContextPath()%>/Empleados/estadisticas.jsp"> Estadísticas </a>
      <a href="<%=request.getContextPath()%>/Empleados/solicitudes.jsp"> Solicitudes </a>
    </div>

    <div class="texto1">
        <h2> PROYECTOS </h2>
        
        <table id="tablaProyectos" > 
            <thead> 
                <tr> 
                    <th scope="col">Id</th> 
                    <th scope="col">Descripcion</th>
                    <th scope="col">CIF</th>
                </tr> 
            </thead> 
            <tbody> 
                <c:forEach items="${proyectosTrabajador}" var="proyectos"> 
                    <tr> 
                        <td scope="row"><c:out value="${proyectos.id}" /></td> 
                        <td><c:out value="${proyectos.descripcion}" /></td> 
                        <td><c:out value="${proyectos.cif_empresa}" /></td>  
                    </tr> 
                </c:forEach> 
            </tbody> 
        </table> 

        <ul class="listas">
            <button class="boton">
              <a id="añadir_p1" onclick="añadirP1()"> Añadir </a>
            </button>
        </ul>
        
    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>
  </body>

</html>