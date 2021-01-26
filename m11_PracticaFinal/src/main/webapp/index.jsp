<%-- 
    Document   : index
    Created on : 13-ene-2021, 19:43:19
    Author     : danih
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en"> 
  <head>

    <title>Inicio</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link href="style_sheet.css" rel="stylesheet">
    <script src="funciones.js"></script>
  </head>
  <body>
    <%HttpSession sesion=request.getSession(); 
    if (!sesion.isNew()){
        sesion.invalidate();
    }
    %>
    
    <h1>INGENIEROS AL PESO</h1>
    
    <div class="navbar">
      <a href="<%=request.getContextPath()%>/Empleados/main.jsp"> Empleados </a>
      <a href="<%=request.getContextPath()%>/RRHH/main.jsp"> RRHH </a>
    </div>

    <div class="texto1">
        <form  method="POST" action='LoginController' id="formulario">
            <br>
            <h1>Iniciar Sesión</h1>
            <p>Correo de Usuario: <input type="text"  name="correo" size="40"></p>
            <p>Contraseña: <input type="password" name="pwd" placeholder="Password" size="40"></p>
            <p>
              <button class="boton">
                <a id="desconectar" onclick="validarLogin()"> INICIAR SESION </a>
              </button>
              <button class="boton">
                <a id="desconectar" onclick="borrar()"> CANCELAR </a>
              </button>
              
            </p>
            <br>
        </form>
    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>
  </body>

</html>