<%-- 
    Document   : proyectos
    Created on : 13-ene-2021, 11:45:49
    Author     : danih
--%>

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
    <link href="<%=request.getContextPath()%>/style_sheet.css" rel="stylesheet">

  </head>

  <body>

    <h1>LOGO INGENIEROS AL PESO</h1>
    <h2>EMPLEADOS</h2>

    <div class="navbar">
      <a href="<%=request.getContextPath()%>/Empleados/main.jsp"> Inicio </a>
      <a href="<%=request.getContextPath()%>/Empleados/registro_diario.jsp"> Registro diario </a>
      <a href="<%=request.getContextPath()%>/Empleados/proyectos.jsp"> Proyectos </a>
      <a href="<%=request.getContextPath()%>/Empleados/calendario.jsp"> Calendario </a>
      <a href="<%=request.getContextPath()%>/Empleados/estadisticas.jsp"> Estadísticas </a>
      <a href="<%=request.getContextPath()%>/Empleados/solicitudes.jsp"> Solicitudes </a>
    </div>

    <div class="texto1">
        <h2> PROYECTOS </h2>
        <table class="table table-striped"> 
            <thead> 
                <tr> 
                    <th scope="col">Id</th> 
                </tr> 
            </thead> 
            <tbody> 
                <c:forEach items="${proyectos}" var="proyecto"> 
                    <tr> 
                        <td scope="row"><c:out value="${proyecto.id}" /></td>     
                    </tr> 
                </c:forEach> 
            </tbody> 
        </table> 

        <ul class="listas">
          <li type="dot"> Proyecto 1</li>
            <p>Total de horas invertidas . . . . . . . . . . <input class="campo_texto" type="text" name="textofijo" value="00" readonly> h </p>
            <p>Horas a añadir <input class="campo_texto" type="number" name="textofijo" value="0"></p>
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