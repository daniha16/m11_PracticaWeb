<%-- 
    Document   : main
    Created on : 15-ene-2021, 14:06:00
    Author     : danih
--%>

<%@page import="model.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>main</title>
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
    <h1>RECURSOS HUMANOS</h1>
    <div class="navbar">
      <a href="<%=request.getContextPath()%>/RRHH/main.jsp">Home  </a>
      <a href="<%=request.getContextPath()%>/RRHH/informacion.jsp">Información</a>
      <a href="<%=request.getContextPath()%>/PeticionesController?action=listPeticiones">Peticiones de Trabajadores</a>
      <a href="<%=request.getContextPath()%>/RRHH/informe.jsp">Solicitar Informe</a>
    </div>


    <div class="texto1">
        <h2>Recursos Humanos</h2>
        <div class="tool">
        </div>
        <br><p>Aqui podras acceder a toda la informacion relevante de nuestra aplicación:</p>
        <br><p>&nbsp;&nbsp;&nbsp;En el apartado Información tendras el contenido relevante de la informacion de las empresas, informacion de los proyectos, informacion de los trabajadores y los calendarios.</p>
        <br><p>&nbsp;&nbsp;&nbsp;En la zona de Peticiones de Trabajadores contamos con todo lo necesario para que cualquier trabajador nos comente sus consultas.</p>
        <br><p>&nbsp;&nbsp;&nbsp;En la pestaña de Solicitar Informe podra solicitar informes de tanto empresas, proyectos y empleados.</p>
        <p>
            <img src="<%=request.getContextPath()%>/RRHH/logo1.png" alt="logo texto">
        </p>
        <button class="boton">
          <a id="desconectar" onclick='location.href="<%=request.getContextPath()%>/LoginController?action=Logout"'> DESCONECTAR </a>
        </button>
    </div>
 
  </body>
</html>