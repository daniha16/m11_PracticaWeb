<%-- 
    Document   : calendario
    Created on : 13-ene-2021, 11:44:13
    Author     : danih
--%>
<%@page import="java.util.List"%>
<%@page import="model.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>

    <title>Calendario</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link HREF="<%=request.getContextPath()%>/style_sheet.css" TYPE="text/css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/animated-event-calendar/dist/simple-calendar.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/animated-event-calendar/dist/jquery.simple-calendar.js"></script>

  </head>

  <body>
    <% 
    Trabajador usuario = (Trabajador)request.getSession().getAttribute("usuario");
    %>
    <h1>EMPLEADOS</h1>
    <p>Usuario: <%=usuario.getNombre()%> </p>
    <div class="navbar">
      <a href="<%=request.getContextPath()%>/Empleados/main.jsp"> Inicio </a>
      <a href="<%=request.getContextPath()%>/Empleados/registro_diario.jsp"> Registro diario </a>
      <a href="<%=request.getContextPath()%>/ProyectoController?action=listTrabajadorProyectos"> Proyectos </a>
      <a href="<%=request.getContextPath()%>/CalendarioController?action=calendario"> Calendario </a>
      <a href="<%=request.getContextPath()%>/Empleados/solicitudes.jsp"> Solicitudes </a>
    </div>
    <div class="texto1">
        <%
            Object listaEventos = request.getAttribute("listaEventos");
        %>

        <h2>CALENDARIO </h2>    
        <div id="container"></div>

        <script type="text/javascript">
            var lista = [{startDate: "2021-01-04 14:48:00", endDate: "2021-01-08 14:48:00",summary:"hola"}]
            $(document).ready(function(){$("#container").simpleCalendar({
                    //Defaults options below
                    //string of months starting from january
                    months: ['january','february','march','april','may','june','july','august','september','october','november','december'],
                    days: ['sunday','monday','tuesday','wednesday','thursday','friday','saturday'],
                    displayYear: true,              // Display year in header
                    fixedStartDay: true,            // Week begin always by monday or by day set by number 0 = sunday, 7 = saturday, false = month always begin by first day of the month
                    displayEvent: true,             // Display existing event
                    disableEventDetails: false, // disable showing event details
                    disableEmptyDetails: true, // disable showing empty date details
                    events:${listaEventos},
                    onInit: function (calendar) {}, // Callback after first initialization
                    onMonthChange: function (month, year) {}, // Callback on month change
                    onDateSelect: function (date, events) {}, // Callback on date selection
                    onEventSelect: function() {}, // Callback on event selection - use $(this).data('event') to access the event
                    onEventCreate: function( $el ) {},          // Callback fired when an HTML event is created - see $(this).data('event')
                    onDayCreate:   function( $el, d, m, y ) {}  // Callback fired when an HTML day is created   - see $(this).data('today'), .data('todayEvents')
            });});
        </script>
    </div>

    <div class="pie">
      <p>Ingenieros al peso S.A.</p>
    </div>
  </body>

</html>