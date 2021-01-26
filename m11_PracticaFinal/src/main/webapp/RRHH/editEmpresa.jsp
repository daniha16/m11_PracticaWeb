<%-- 
    Document   : editEmpresa
    Created on : 24-ene-2021, 11:42:03
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
                        <th scope="col">CIF</th> 
                        <th scope="col">Nombre</th>
                        <th scope="col">Direccion</th>
                        <th scope="col">Codigo Postal</th>
                        <th scope="col">Poblacion</th>
                        <th scope="col">Provincia</th>
                        <th scope="col">Telefono</th>
                        <th scope="col">Acción</th>
                    </tr> 
                </thead> 
                <tbody>  
                    <tr> 
                        <td scope="row"><c:out value="${empresa.cif}" /></td> 
                        <td><input name="nombre" id="nombre" value="<c:out value="${empresa.nombre}" />"></td> 
                        <td><input name="dir" id="dir" value="<c:out value="${empresa.direccion}" />"></td>  
                        <td><input name="cp" id="cp" value="<c:out value="${empresa.codigo_postal}" />"></td>
                        <td><input name="pob" id="pob" value="<c:out value="${empresa.poblacion}" />"></td>
                        <td><input name="prov" id="prov" value="<c:out value="${empresa.provincia}" />"></td>
                        <td><input name="tel" id="tel" value="<c:out value="${empresa.telefono}" />"></td>
                        <td>
                            <input type="button" onclick ='location.href="<%=request.getContextPath()%>/EmpresaController?action=update&cif=<c:out value="${empresa.cif}" />"+"&nombre="+document.getElementById("nombre").value+"&dir="+document.getElementById("dir").value+"&cp="+document.getElementById("cp").value+"&pob="+document.getElementById("pob").value+"&prov="+document.getElementById("prov").value+"&tel="+document.getElementById("tel").value' value="Confirmar">                        
                            <input type="button" onclick ='location.href="<%=request.getContextPath()%>/EmpresaController?action=listEmpresas"' value="Cancelar">
                        </td>
                    </tr> 
                </tbody> 
            </table> 
        </div>
        
    </div>
  </body>
</html>