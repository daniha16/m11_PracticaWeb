/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Peticion;
import model.RegistroEmpleado;
import model.DatosInforme;
import model.Proyecto;
import model.Trabajador;
import model.TrabajadorProyecto;
import util.Log;
import util.ProyectoDao;
import util.RegistroEmpleadoDao;
import util.TrabajadorDao;
import util.TrabajadorProyectoDao;


/**
 *
 * @author danih
 */
public class InformeController extends HttpServlet {

    private static String INICIO = "index.jsp";
    private static String INFORME = "/RRHH/resultadoInforme.jsp";
    private TrabajadorDao daoT;
    private TrabajadorProyectoDao daoTP;
    private RegistroEmpleadoDao daoReg;
    private ProyectoDao daoP;
    public InformeController() {
        super();
        daoT = new TrabajadorDao();
        daoReg = new RegistroEmpleadoDao();
        daoP = new ProyectoDao();
        daoTP = new TrabajadorProyectoDao();
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Log.log.info("Entramos en el doGet");
        HttpSession sesion = request.getSession();
        System.out.println("Comprobando sesiones");
        if(sesion.getAttribute("usuario") == null){
            response.sendRedirect(INICIO);
            return;
        }
        else{
            String forward = "";
            String action = request.getParameter("action");
            Log.log.info("Recogemos el parametro action con valor " + action);
            if (action.equalsIgnoreCase("informe")) {
                System.out.println("INFORME");
                String identificador = request.getParameter("identificador");
                System.out.println(identificador);
                if(identificador.equals("")){
                    System.out.println("AQUIII");
                    response.sendRedirect(request.getContextPath()+"/RRHH/informe.jsp");
                    return;
                }
                forward = INFORME;
                String tipo = request.getParameter("tipo");
                String periodo = request.getParameter("periodo");
                List<RegistroEmpleado> listaRegistros = new ArrayList<RegistroEmpleado>(); 
                List<DatosInforme> datosInforme = new ArrayList<DatosInforme>();
                listaRegistros = daoReg.getAllRegistros();
                java.util.Date date = new java.util.Date();
                System.out.println(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                Date fechaFinal = new Date(0);
                if(periodo.equals("mensual")){
                    calendar.add(Calendar.MONTH, -1);
                    date = (calendar.getTime());
                    fechaFinal = new Date(date.getTime());
                    System.out.println(fechaFinal);
                }
                else if(periodo.equals("anual")){
                    calendar.add(Calendar.YEAR, -1);
                    date = (calendar.getTime());
                    fechaFinal = new Date(date.getTime());
                    System.out.println(fechaFinal);
                }
                else if(periodo.equals("semanal")){
                    calendar.add(Calendar.DAY_OF_YEAR, -7);
                    date = (calendar.getTime());
                    fechaFinal = new Date(date.getTime());
                    System.out.println(fechaFinal);
                }
                else if(periodo.equals("otro")){
                    String otraFecha = request.getParameter("otraFecha");
                    Date fechaAlt = Date.valueOf(otraFecha);
                    fechaFinal=fechaAlt;
                    System.out.println(fechaFinal);
                }
                String[] datePlusTime = fechaFinal.toString().split(" ");
                if(tipo.equals("empleado")){
                    for(RegistroEmpleado registro: listaRegistros){
                        System.out.println(registro.getFecha());
                        if(Date.valueOf(datePlusTime[0]).before(registro.getFecha()) && registro.getIden_trabajador()==Integer.parseInt(identificador)){
                            DatosInforme informe = new DatosInforme();
                            Trabajador empleado = daoT.getTrabajadorByIden(registro.getIden_trabajador());
                            informe.setIden(registro.getIden_trabajador());
                            informe.setApellidos(empleado.getApellidos());
                            informe.setDni(empleado.getDni());
                            informe.setFecha(Date.valueOf(datePlusTime[0]));
                            informe.setNombre(empleado.getNombre());
                            informe.setEntrada(registro.getEntrada());
                            informe.setSalida(registro.getSalida());
                            datosInforme.add(informe);
                        }
                    }
                }
                else if(tipo.equals("proyecto")){
                    List<Integer> listaIden = new ArrayList<Integer>();
                    System.out.println(identificador);
                    System.out.println(daoTP.getTPByIdProyecto(identificador));
                    for(TrabajadorProyecto tp: daoTP.getTPByIdProyecto(identificador)){
                        listaIden.add(tp.getIden_trabajador());
                    }                    
                    for(RegistroEmpleado registro: listaRegistros){
                        System.out.println(registro.getFecha());
                        if(Date.valueOf(datePlusTime[0]).before(registro.getFecha()) && listaIden.contains(registro.getIden_trabajador())){
                            DatosInforme informe = new DatosInforme();
                            Trabajador empleado = daoT.getTrabajadorByIden(registro.getIden_trabajador());
                            informe.setIden(registro.getIden_trabajador());
                            informe.setApellidos(empleado.getApellidos());
                            informe.setDni(empleado.getDni());
                            informe.setFecha(Date.valueOf(datePlusTime[0]));
                            informe.setNombre(empleado.getNombre());
                            informe.setEntrada(registro.getEntrada());
                            informe.setSalida(registro.getSalida());
                            datosInforme.add(informe);
                        }
                    }
                }
                else if(tipo.equals("empresa")){
                    List<String> listaIds = new ArrayList<String>();
                    System.out.println(identificador);
                    System.out.println(daoP.getAllProyectosByCif(identificador));
                    for(Proyecto proyecto: daoP.getAllProyectosByCif(identificador)){
                        listaIds.add(proyecto.getId());
                    }                    
                    System.out.println(listaIds);
                    List<Integer> listaIden = new ArrayList<Integer>();
                    for(String id: listaIds){
                        for(TrabajadorProyecto tp: daoTP.getTPByIdProyecto(id)){
                            listaIden.add(tp.getIden_trabajador());
                        }
                    }
                    System.out.println(listaIden);
                    for(RegistroEmpleado registro: listaRegistros){
                        System.out.println(registro.getFecha());
                        if(Date.valueOf(datePlusTime[0]).before(registro.getFecha()) && listaIden.contains(registro.getIden_trabajador())){
                            DatosInforme informe = new DatosInforme();
                            Trabajador empleado = daoT.getTrabajadorByIden(registro.getIden_trabajador());
                            informe.setIden(registro.getIden_trabajador());
                            informe.setApellidos(empleado.getApellidos());
                            informe.setDni(empleado.getDni());
                            informe.setFecha(Date.valueOf(datePlusTime[0]));
                            informe.setNombre(empleado.getNombre());
                            informe.setEntrada(registro.getEntrada());
                            informe.setSalida(registro.getSalida());
                            datosInforme.add(informe);
                        }
                    }
                }
                request.setAttribute("resultadoInforme", datosInforme);
            }else {
                Log.log.info("Parametro valor vacio vamos a insertar");
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
        HttpSession sesion = request.getSession();
        if(sesion.getAttribute("usuario") == null){
            response.sendRedirect(INICIO);
        }
/*        processRequest(request, response); */
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
