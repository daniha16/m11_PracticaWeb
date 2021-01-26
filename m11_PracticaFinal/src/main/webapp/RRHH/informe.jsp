<%-- 
    Document   : informe
    Created on : 15-ene-2021, 14:10:05
    Author     : danih
--%>

<%@page import="model.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>informe</title>
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
    
    <h1>LOGO RRHH</h1>
    <h2>Recursos Humanos</h2>
    <p>BIENVENIDO <%=usuario.getNombre()%>! </p>
    <div class="navbar">
      <a href="<%=request.getContextPath()%>/RRHH/main.jsp">Home  </a>
      <a href="<%=request.getContextPath()%>/RRHH/informacion.jsp">Información</a>
      <a href="<%=request.getContextPath()%>/PeticionesController?action=listPeticiones">Peticiones de Trabajadores</a>
      <a href="<%=request.getContextPath()%>/RRHH/informe.jsp">Solicitar Informe</a>
    </div>

    <script type="text/javascript"> 
        function validarEntrada(){
            var selector1 = document.getElementById("selector1").value;
            var selector2 = document.getElementById("selector2").value;
            var iden = document.getElementById("identificador").value;
            if(iden === null || iden.length===0){
                 alert("El campo esta vacío");
            }
            else if(selector1==="empleado" && !Number.isInteger(parseInt(iden,10))){
                alert("El valor introducido no se corresponde con el tipo seleccionado");       
            }
            else{
                location.href="<%=request.getContextPath()%>/InformeController?action=informe&tipo="+document.getElementById("selector1").value+"&periodo="+document.getElementById("selector2").value+"&identificador="+document.getElementById("identificador").value+"&otraFecha="+document.getElementById("tipo").value;
            }
        }
    </script>
    <script type="text/javascript">
        function comprobarTipo(){
            var opcion = document.getElementById("selector2").value;
            if(opcion==="otro"){
                document.getElementById("tipo").type="date";
            }
            else{
                document.getElementById("tipo").type="hidden";
            }
        }
    </script>
    <div class="texto1">
        <h1>INFORME</h1>
        <p>Introduzca el tipo de informe a solicitar:</p>
        <p>Introduzca identificador de usuario, de proyecto o el cif de empresa según corresponda<p>
        <select class="custom-select" id="selector1">
          <option value="empleado">Empleado</option>
          <option value="proyecto">Proyecto</option>
          <option value="empresa">Empresa</option>
        </select>
            <select class="custom-select" id="selector2" onchange="comprobarTipo()">
          <option value="semanal">Semanal</option>
          <option value="mensual">Mensual</option>
          <option value="anual">Anual</option>
          <option value="otro">Otro</option>
        </select>
        <input type="text" id="identificador" placeholder="identificador"> 
        <input type="hidden" id="tipo" placeholder="fecha: 2021-01-01"> 
        <input type="button" onclick ='validarEntrada()' value="Aceptar">   
    </div>






    
  </body>
</html>