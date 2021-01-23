<%-- 
    Document   : proyectosRRHH
    Created on : 15-ene-2021, 14:35:29
    Author     : danih
--%>

<%@page import="model.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>informacion</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
  <link href="<%=request.getContextPath()%>/style_sheet.css" rel="stylesheet">
  <script src="<%=request.getContextPath()%>/funciones.js"></script>
</head>
  <body>
    <% 
    Trabajador usuario = (Trabajador)request.getSession().getAttribute("usuario");
    %>

    <!--<img src=" " alt="logo pagina">-->
    <h1>LOGO RRHH</h1>
    <h2>Recursos Humanos</h2>
    <p>BIENVENIDO <%=usuario.getNombre()%>! </p>
    <div class="navbar">
      <a href="<%=request.getContextPath()%>/RRHH/main.jsp">Home  </a>
      <a href="<%=request.getContextPath()%>/RRHH/informacion.jsp">Información</a>
      <a href="<%=request.getContextPath()%>/PeticionesController?action=listPeticiones">Peticiones de Trabajadores</a>
      <a href="<%=request.getContextPath()%>/RRHH/informe.jsp">Solicitar Informe</a>
    </div>


    <div class="texto1">
        <div class="navbarRRHH">
            <a href="<%=request.getContextPath()%>/EmpleadoController?action=listEmpleados">Trabajadores</a>
            <a href="<%=request.getContextPath()%>/ProyectoController?action=listProyectosRRHH">Proyectos</a>
            <a href="<%=request.getContextPath()%>/EmpresaController?action=listEmpresas">Empresas</a>
        </div> 
        <div class="infoTable">
            <table id="tablaEmpleados" > 
                <thead> 
                    <tr> 
                        <th scope="col">ID</th> 
                        <th scope="col">Descripción</th>
                        <th scope="col">CIF Empresa</th>
                        <th scope="col">Acción</th>
                    </tr> 
                </thead> 
                <tbody> 
                    <c:forEach items="${listaProyectos}" var="proyecto"> 
                        <tr> 
                            <td scope="row"><c:out value="${proyecto.id}" /></td> 
                            <td><c:out value="${proyecto.descripcion}" /></td> 
                            <td><c:out value="${proyecto.cif_empresa}" /></td>  
                            <td>
                                <input type="button" onclick ='location.href="<%=request.getContextPath()%>/ProyectoController?action=update&proyectoId=<c:out value="${proyecto.id}" />"' value="Editar">                        
                                <input type="button" onclick ='location.href="<%=request.getContextPath()%>/ProyectoController?action=delete&proyectoId=<c:out value="${proyecto.id}" />"' value="Eliminar">
                            </td>
                        </tr> 
                    </c:forEach> 
                </tbody> 
            </table> 
        </div>
    </div>
        
    
  </body>
</html>