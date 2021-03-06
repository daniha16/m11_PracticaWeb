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
    <h1>RECURSOS HUMANOS</h1>
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
                        <th scope="col">Acción</th>
                    </tr> 
                </thead> 
                <tbody>  
                    <tr> 
                        <td scope="row"><c:out value="${empleado.iden}" /></td> 
                        <td><input name="dni" id="dni" value="<c:out value="${empleado.dni}" />"></td> 
                        <td><input name="nombre" id="nombre" value="<c:out value="${empleado.nombre}" />"></td>  
                        <td><input name="apellidos" id="apellidos" value="<c:out value="${empleado.apellidos}" />"></td>  
                        <td><input name="telefono" id="telefono" value="<c:out value="${empleado.telefono}" />"></td>  
                        <td>
                            <input type="button" onclick ='location.href="<%=request.getContextPath()%>/EmpleadoController?action=update&iden=<c:out value="${empleado.iden}" />"+"&dni="+document.getElementById("dni").value+"&nombre="+document.getElementById("nombre").value+"&apellidos="+document.getElementById("apellidos").value+"&telefono="+document.getElementById("telefono").value' value="Confirmar">                        
                            <input type="button" onclick ='location.href="<%=request.getContextPath()%>/EmpleadoController?action=listEmpleados"' value="Cancelar">
                        </td>
                    </tr> 
                </tbody> 
            </table> 
        </div>
        
    </div>
  </body>
</html>