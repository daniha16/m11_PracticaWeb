<%-- 
    Document   : peticiones
    Created on : 15-ene-2021, 14:10:43
    Author     : danih
--%>

<%@page import="model.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>peticiones</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link href="<%=request.getContextPath()%>/style_sheet.css" rel="stylesheet">
  </head>
  <body>
    <% 
    Trabajador usuario = (Trabajador)request.getSession().getAttribute("usuario");
    %>
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
        <div class="infoTable">
            <table id="tablaEmpleados" > 
                <thead> 
                    <tr> 
                        <th scope="col">ID Peticion</th> 
                        <th scope="col">Empleado</th> 
                        <th scope="col">Concepto</th>
                        <th scope="col">Resolución</th>
                        <th scope="col">Acción</th>
                    </tr> 
                </thead> 
                <tbody> 
                    <c:forEach items="${listaPeticiones}" var="peticion"> 
                        <tr> 
                            <td scope="row"><c:out value="${peticion.reqid}" /></td> 
                            <td><c:out value="${peticion.iden}" /></td>
                            <td><c:out value="${peticion.concepto}" /></td> 
                            <td><c:out value="${peticion.resolucion}"/></td>  
                            <td> 
                                <input type="button" onclick = "adminResolucion()" value="Aceptar">                          
                                <input type="button" onclick = "adminResolucion()" value="Denegar">   
                            </td>  
                        </tr> 
                    </c:forEach> 
                </tbody> 
            </table> 
        </div>
    </div>


    

  </body>
</html>