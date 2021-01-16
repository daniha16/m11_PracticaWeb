<%-- 
    Document   : empresasRRHH
    Created on : 15-ene-2021, 14:35:58
    Author     : danih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>informacion</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
  <link href="<%=request.getContextPath()%>/style_sheet.css" rel="stylesheet">
</head>
  <body>


    <!--<img src=" " alt="logo pagina">-->
    <h1>LOGO RRHH</h1>
    <h2>Recursos Humanos</h2>

    <div class="navbar">
      <a href="<%=request.getContextPath()%>/RRHH/main.jsp">Home  </a>
      <a href="<%=request.getContextPath()%>/RRHH/informacion.jsp">Información</a>
      <a href="<%=request.getContextPath()%>/RRHH/peticiones.jsp">Peticiones de Trabajadores</a>
      <a href="<%=request.getContextPath()%>/RRHH/informe.jsp">Solicitar Informe</a>
    </div>


    <div class="texto1">
        <div class="navbarVertical">
            <a href="<%=request.getContextPath()%>/RRHH/trabajadoresRRHH.jsp">Trabajadores</a>
            <a href="<%=request.getContextPath()%>/RRHH/proyectosRRHH.jsp">Proyectos</a>
            <a href="<%=request.getContextPath()%>/RRHH/empresasRRHH.jsp">Empresas</a>
        </div> 
    </div>
        
    
  </body>
</html>