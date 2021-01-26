<%-- 
    Document   : resultadoInforme
    Created on : 26-ene-2021, 17:56:26
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

        <div class="infoTable">
            <table id="tablaEmpleados" > 
                <thead> 
                    <tr> 
                        <th scope="col">Identidicador</th> 
                        <th scope="col">DNI</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">Entrada</th>
                        <th scope="col">Salida</th>
                    </tr> 
                </thead> 
                <tbody> 
                    <c:forEach items="${resultadoInforme}" var="informe"> 
                        <tr> 
                            <td scope="row"><c:out value="${informe.iden}" /></td>
                            <td><c:out value="${informe.dni}" /></td>
                            <td><c:out value="${informe.nombre}" /></td>
                            <td><c:out value="${informe.apellidos}" /></td>
                            <td><c:out value="${informe.entrada}" /></td>
                            <td><c:out value="${informe.salida}" /></td>
                        </tr> 
                    </c:forEach> 
                </tbody> 
            </table> 
        </div>
        
    </div>
  </body>
</html>