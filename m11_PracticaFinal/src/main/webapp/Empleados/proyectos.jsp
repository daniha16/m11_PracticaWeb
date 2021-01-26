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
        
        <table id="tablaProyectos" > 
            <thead> 
                <tr> 
                    <th scope="col">Id</th> 
                    <th scope="col">Descripcion</th>
                    <th scope="col">CIF</th>
                    <th scope="col">Horas</th>
                    <th scope="col">Accion</th>
                </tr> 
            </thead> 
            <tbody> 
                <c:forEach items="${proyectosTrabajador}" var="proyecto"> 
                    <tr> 
                        <td scope="row"><c:out value="${proyecto.id}" /></td> 
                        <td><c:out value="${proyecto.descripcion}" /></td> 
                        <td><c:out value="${proyecto.cif_empresa}" /></td>  
                        <td><c:out value="${proyecto.tiempo}" /></td>
                        <td><input type="button" onclick ='location.href="<%=request.getContextPath()%>/ProyectoController?action=addTime&id=<c:out value="${proyecto.id}" />"' value="Añadir Horas"></td>   
                    </tr> 
                </c:forEach> 
            </tbody> 
        </table> 
        
    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>
  </body>

</html>