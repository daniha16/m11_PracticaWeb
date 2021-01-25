/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Proyecto;
import model.RegistroEmpleado;
import util.Log;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import model.Trabajador;
import util.RegistroEmpleadoDao;

/**
 *
 * @author danih
 */
public class RegistroEmpleadoController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static String MARCAJE_DIARIO = "/Empleados/registro_diario.jsp";
    private static String REGISTROS_EMPLEADOS = "/Empleados/registro_diario.jsp";
    private static String INICIO = "index.jsp";
    private RegistroEmpleadoDao dao;
    private Log log;

    public RegistroEmpleadoController(){
        super();
        dao = new RegistroEmpleadoDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        System.out.println("Comprobando sesiones");
        if(sesion.getAttribute("usuario") == null){
            System.out.println("NO HAY SESIOOOOON");
            response.sendRedirect(INICIO);
        }
        else{
            String forward = "";
            Log.log.info("Entramos en el doGet");
            String action = request.getParameter("action");
            Log.log.info("Recogemos el parametro action con valor " + action);
            if (action.equalsIgnoreCase("entrada")) {
                Log.log.info("Parametro valor ENTRADA");
                LocalDate localdate = LocalDate.now();
                Date fecha = new Date();
                long tiempo = fecha.getTime();
                Timestamp entrada = new Timestamp(tiempo);
                Trabajador user = (Trabajador)sesion.getAttribute("usuario");
                int iden = user.getIden();
                System.out.println("DATE: "+localdate);
                List<RegistroEmpleado> listaRegistros = new ArrayList<RegistroEmpleado>();
                listaRegistros = dao.getAllRegistros();
                System.out.println("ANTES DEL FOR");
                for(RegistroEmpleado elem: listaRegistros){
                    System.out.println("DESPUES DEL FOR");
                    String stringFecha = elem.getEntrada().toString();
                    System.out.println(stringFecha);
                    String[] fecha_tiempo = stringFecha.split(" ");
                    System.out.println(fecha_tiempo[0]+"=="+localdate.toString());
                    if(elem.getIden_trabajador()==iden && fecha_tiempo[0].equals(localdate.toString())){
                        System.out.println("YA HAS REALIZADO EL MARCAJE DIARIO");
                        response.sendRedirect(request.getContextPath()+REGISTROS_EMPLEADOS);
                        return;
                    }
                }
                System.out.println("ME LO HE SALTADO");
                RegistroEmpleado reg = new RegistroEmpleado();
                reg.setEntrada(entrada);
                reg.setIden_trabajador(iden);
                dao.addRegistroEmpleado(reg);
                System.out.println("TIMESTAMP: "+entrada);
                forward = MARCAJE_DIARIO;

            }else if (action.equalsIgnoreCase("salida")) {
                Log.log.info("Parametro valor SALIDA");
                Date fecha = new Date();
                long tiempo = fecha.getTime();
                Timestamp salida = new Timestamp(tiempo);
                LocalDate localdate = LocalDate.now();
                Trabajador user = (Trabajador)sesion.getAttribute("usuario");
                int iden = user.getIden();
                //System.out.println("FECHA: "+fecha_tiempo[0]+", TIEMPO: "+fecha_tiempo[1]);
                List<RegistroEmpleado> listaRegistros = new ArrayList<RegistroEmpleado>();
                listaRegistros = dao.getAllRegistros();
                RegistroEmpleado reg = new RegistroEmpleado();
                for(RegistroEmpleado elem: listaRegistros){
                    System.out.println("DESPUES DEL FOR");
                    String stringFecha = elem.getEntrada().toString();
                    String[] fecha_tiempo = stringFecha.split(" ");
                    if(elem.getIden_trabajador()==iden && fecha_tiempo[0].equals(localdate.toString())){
                        reg.setEntrada(elem.getEntrada());
                        reg.setSalida(salida);
                        reg.setIden_trabajador(iden);
                        reg.setFecha(elem.getFecha());
                        dao.updateRegistroEmpleados(reg);
                        response.sendRedirect(request.getContextPath()+REGISTROS_EMPLEADOS);
                        return;
                    }
                }
                System.out.println("TIMESTAMP: "+salida);
                
                forward = MARCAJE_DIARIO;

            }
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Log.log.info("Entramos por el doPost");
/*        processRequest(request, response); */
        Proyecto proyecto = new Proyecto();
        proyecto.setId(request.getParameter("proyectoId"));
        proyecto.setDescripcion(request.getParameter("proyectoText"));                
        proyecto.setCif_empresa(request.getParameter("cif_empresa"));
        proyecto.setId(request.getParameter("proyectoId"));
        request.setAttribute("proyectos", dao.getAllRegistros());
        RequestDispatcher view = request.getRequestDispatcher(REGISTROS_EMPLEADOS);            
        view.forward(request, response);
        return;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
