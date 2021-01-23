<%-- 
    Document   : empleadosRRHH
    Created on : 15-ene-2021, 14:35:44
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


    <div class="menuBar">
        <div class="navbarRRHH">
            <a href="<%=request.getContextPath()%>/EmpleadoController?action=listEmpleados">Trabajadores</a>
            <a href="<%=request.getContextPath()%>/ProyectoController?action=listProyectosRRHH">Proyectos</a>
            <a href="<%=request.getContextPath()%>/EmpresaController?action=listEmpresas">Empresas</a>
        </div> 
        <div class="infoTable">
            <table id="tablaEmpleados" > 
                <thead> 
                    <tr> 
                        <th scope="col">Identidicador</th> 
                        <th scope="col">DNI</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">Telefono</th>
                    </tr> 
                </thead> 
                <tbody> 
                    <c:forEach items="${listaEmpleados}" var="empleados"> 
                        <tr> 
                            <td scope="row"><c:out value="${empleados.iden}" /></td> 
                            <td><c:out value="${empleados.dni}" /></td> 
                            <td><c:out value="${empleados.nombre}" /></td>  
                            <td><c:out value="${empleados.apellidos}" /></td>  
                            <td><c:out value="${empleados.telefono}" /></td>  
                        </tr> 
                    </c:forEach> 
                </tbody> 
            </table> 
        </div>
        
    </div>
    
    
        
    
  </body>
</html>