<%-- 
    Document   : horas_sol
    Created on : 13-ene-2021, 11:45:10
    Author     : danih
--%>

<%@page import="model.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>

    <title>Solicitud</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link HREF="<%=request.getContextPath()%>/style_sheet.css" TYPE="text/css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/funciones.js"></script>
  <body>
    <% 
    Trabajador usuario = (Trabajador)request.getSession().getAttribute("usuario");
    %>
    <h1>LOGO INGENIEROS AL PESO</h1>
    <h2>EMPLEADOS</h2>
    <p>Usuario: <%=usuario.getNombre()%> </p>
    <div class="navbar">
      <a href="<%=request.getContextPath()%>/Empleados/main.jsp"> Inicio </a>
      <a href="<%=request.getContextPath()%>/Empleados/registro_diario.jsp"> Registro diario </a>
      <a href="<%=request.getContextPath()%>/ProyectoController?action=listTrabajadorProyectos"> Proyectos </a>
      <a href="<%=request.getContextPath()%>/Empleados/calendario.jsp"> Calendario </a>
      <a href="<%=request.getContextPath()%>/Empleados/solicitudes.jsp"> Solicitudes </a>
    </div>
    <script type="text/javascript">
        function validarHora(){
            var min = '08:30';
            var max = '18:00';
            if(document.getElementById("horaEntrada").value>=min && document.getElementById("horaEntrada").value<max && document.getElementById("horaSalida").value>min && document.getElementById("horaSalida").value<=max){
                location.href="<%=request.getContextPath()%>/PeticionesController?action=solicitarHoras&entrada="+document.getElementById("horaEntrada").value+"&salida="+document.getElementById("horaSalida").value+"&concepto="+document.getElementById("concepto").value+"&fecha="+document.getElementById("fecha").value
            }
            else{
                alert("La hora especificada no esta dentro del horario de trabajo")
            }
        }
    </script>
    <div class="texto1">
        <h2> SOLICITUD DE HORAS LIBRES </h2>
        <p>El horario de la oficina es de 08:30h a 18:00h</p>
        <br><label for="horaEntrada">Selecciona la hora de inicio . . . . .</label>
        <input type="time" id="horaEntrada" value="00:00" name="horaEntrada" min="08:30" max="18:00" required> <br>
        <br><label for="horaSalida">Selecciona la hora de fin . . .</label>
        <input type="time" id="horaSalida" value="00:00" name="horaSalida" min="08:30" max="18:00" required> <br>
        <br><label for="fechaseleccionada">Selecciona el día libre</label>
        <br><input type="date" id="fecha" name="fecha" value="2021-01-01" min="2021-01-01" max="2030-12-31"> <br>
        <br><label for="concepto">Indique breve conepto:</label>
        <br><input type="text" id="concepto" name="concepto"> <br>
        <br><button class="boton">
                <a id="solicitarFecha" onclick='validarHora()'> Solicitar</a>
            </button>
    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>

  </body>

</html>