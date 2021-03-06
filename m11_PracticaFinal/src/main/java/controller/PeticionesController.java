/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Peticion;
import model.Trabajador;
import util.Log;
import util.PeticionesDao;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Vacaciones;
import util.VacacionesDao;

/**
 *
 * @author danih
 */
public class PeticionesController extends HttpServlet {
    private static String INICIO = "index.jsp";
    private static String LIST_PETICIONES = "/RRHH/peticiones.jsp";
    private static String INSERT_OR_EDIT = "/RRHH/peticiones.jsp";
    private static String SOLICITAR_DIAS = "/Empleados/solicitudes.jsp";
    private PeticionesDao dao;
    private VacacionesDao dao2;
    public PeticionesController() {
        super();
        dao = new PeticionesDao();
        dao2 = new VacacionesDao();
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
            if (action.equalsIgnoreCase("delete")) {
                Log.log.info("Parametro valor DELETE");
                int reqId = Integer.parseInt(request.getParameter("peticionId"));
                dao.deletePeticion(reqId);
                forward = LIST_PETICIONES;
                request.setAttribute("peticiones", dao.getAllPeticiones());
            } else if (action.equalsIgnoreCase("edit")) {
                Log.log.info("Parametro valor EDIT");
                forward = INSERT_OR_EDIT;
                int reqId = Integer.parseInt(request.getParameter("peticionId"));
                Peticion peticion = dao.getPeticionById(reqId);
                request.setAttribute("peticion", peticion);
            } else if (action.equalsIgnoreCase("listPeticiones")) {
                Log.log.info("Parametro valor LIST");
                System.out.println("ESTOY EN LISTA PETICIONES");
                forward = LIST_PETICIONES;
                request.setAttribute("listaPeticiones", dao.getAllPeticiones());
                System.out.println(dao.getAllPeticiones());
                for(Peticion i:dao.getAllPeticiones()){
                    System.out.println(i.getReqid());
                }
            } else if (action.equalsIgnoreCase("denegar")) {
                Log.log.info("Parametro valor LIST");
                System.out.println("ESTOY EN DENEGAR");
                forward = LIST_PETICIONES;
                System.out.println("Antes de petar");
                int reqId = Integer.parseInt(request.getParameter("reqId"));
                System.out.println("REQID: "+reqId);
                dao.denegarPeticion(reqId);
                request.setAttribute("listaPeticiones", dao.getAllPeticiones());
                System.out.println(dao.getAllPeticiones());
                for(Peticion i:dao.getAllPeticiones()){
                    System.out.println(i.getReqid());
                }
            }else if (action.equalsIgnoreCase("aceptar")) {
                Log.log.info("Parametro valor LIST");
                System.out.println("ESTOY EN ACEPTAR");
                forward = LIST_PETICIONES;
                System.out.println("Antes de petar");
                int reqId = Integer.parseInt(request.getParameter("reqId"));
                System.out.println("REQID: "+reqId);
                System.out.println("DE AQUI NO PASA");
                dao.aceptarPeticion(reqId);
                System.out.println("SORPRESA");
                request.setAttribute("listaPeticiones", dao.getAllPeticiones());
                System.out.println("DOBLE SORPRESA");
                System.out.println(dao.getAllPeticiones());
                for(Peticion i:dao.getAllPeticiones()){
                    System.out.println(i.getReqid());
                }
                Peticion peticion = dao.getPeticionById(reqId);
                System.out.println("KILLTACULAR");
                Vacaciones vacaciones = new Vacaciones();
                vacaciones.setInicio(peticion.getInicio());
                vacaciones.setFin(peticion.getFin());
                vacaciones.setIden_trabajador(peticion.getIden());
                vacaciones.setTipo(peticion.getTipo());
                vacaciones.setConcepto(peticion.getConcepto());
                System.out.println("TIPO: "+vacaciones.getTipo());
                dao2.addVacaciones(vacaciones);
                request.setAttribute("listaPeticiones", dao.getAllPeticiones());
            }else if(action.equalsIgnoreCase("solicitarHoras")){
                System.out.println("QUE PACHAAAA");
                System.out.println("TIEMPO: "+request.getParameter("entrada").toString());
                Time entrada = Time.valueOf(request.getParameter("entrada")+":00");
                System.out.println("ENTRADA: "+entrada);
                Time salida = Time.valueOf(request.getParameter("salida")+":00");
                System.out.println("SALIDA: "+salida);
                String concepto=request.getParameter("concepto");
                Date date = Date.valueOf(request.getParameter("fecha"));
                System.out.println("DATE: "+date);
                Trabajador user = (Trabajador)sesion.getAttribute("usuario");
                Timestamp inicio = Timestamp.valueOf(date+" "+entrada);
                Timestamp fin = Timestamp.valueOf(date+" "+salida);
                System.out.println("INICIO: "+inicio+" /FIN: "+fin);
                int iden = user.getIden();
                List<Peticion> listaPeticiones = new ArrayList<Peticion>();
                listaPeticiones = dao.getAllPeticiones();
                int reqid=0;
                if (listaPeticiones==null){
                    reqid=1;      
                }
                else{
                    int max = 0;
                    for(Peticion elem: listaPeticiones){
                        if(elem.getReqid()>max){
                            max=elem.getReqid();
                        }
                    }
                    reqid=max+1;
                }
                Peticion peticion=new Peticion();
                peticion.setReqid(reqid);
                peticion.setIden(iden);
                peticion.setResolucion("Pendiente");
                peticion.setInicio(inicio);
                System.out.println("LA MAGIA: "+peticion.getInicio());
                peticion.setFin(fin);
                peticion.setConcepto(concepto);
                peticion.setTipo("Horas");
                dao.addPeticion(peticion);
                System.out.println("HORA: "+Time.valueOf("00:00:00"));
                response.sendRedirect(request.getContextPath()+SOLICITAR_DIAS);
                return;
            }else if(action.equalsIgnoreCase("solicitarDia")){
                System.out.println("YA ETOY");
                forward = SOLICITAR_DIAS;
                Date date = Date.valueOf(request.getParameter("fecha"));
                System.out.println(date);
                Trabajador user = (Trabajador)sesion.getAttribute("usuario");
                String concepto=request.getParameter("concepto");
                System.out.println(concepto);
                List<Peticion> listaPeticiones = new ArrayList<Peticion>();
                listaPeticiones = dao.getAllPeticiones();
                int iden = user.getIden();
                int reqid=0;
                if (listaPeticiones==null){
                    reqid=1;      
                }
                else{
                    int max = 0;
                    for(Peticion elem: listaPeticiones){
                        if(elem.getReqid()>max){
                            max=elem.getReqid();
                        }
                    }
                    reqid=max+1;
                }
                Peticion peticion=new Peticion();
                peticion.setReqid(reqid);
                peticion.setIden(iden);
                peticion.setResolucion("Pendiente");
                peticion.setInicio(Timestamp.valueOf(date+" 00:00:00"));
                System.out.println("LA MAGIA: "+peticion.getInicio());
                peticion.setFin(Timestamp.valueOf(date+" 23:59:59"));
                System.out.println("LA MAGIA 2: "+peticion.getFin());
                peticion.setConcepto(concepto);
                peticion.setTipo("Dia");
                dao.addPeticion(peticion);
                System.out.println("HORA: "+Time.valueOf("00:00:00"));
                response.sendRedirect(request.getContextPath()+SOLICITAR_DIAS);
                return;
            }else if(action.equalsIgnoreCase("necesitoVacaciones")){
                System.out.println("YA ETOY");
                forward = SOLICITAR_DIAS;
                Trabajador user = (Trabajador)sesion.getAttribute("usuario");
                String concepto=request.getParameter("concepto");
                System.out.println(concepto);
                int iden = user.getIden();
                java.util.Date inicio = Date.valueOf(request.getParameter("start"));
                System.out.println("INI: "+inicio);
                java.util.Date fin = Date.valueOf(request.getParameter("end"));
                System.out.println("FIN: "+fin);
                System.out.println("CON: "+concepto);
                List<Peticion> listaPeticiones = new ArrayList<Peticion>();
                listaPeticiones = dao.getAllPeticiones();
                int reqid=0;
                if (listaPeticiones==null){
                    reqid=1;      
                }
                else{
                    int max = 0;
                    for(Peticion elem: listaPeticiones){
                        if(elem.getReqid()>max){
                            max=elem.getReqid();
                        }
                    }
                    reqid=max+1;
                }
                Peticion peticion=new Peticion();
                peticion.setReqid(reqid);
                peticion.setIden(iden);
                peticion.setResolucion("Pendiente");
                peticion.setInicio(Timestamp.valueOf(inicio+" 00:00:00"));
                System.out.println("LA MAGIA: "+peticion.getInicio());
                peticion.setFin(Timestamp.valueOf(fin+" 23:59:59"));
                System.out.println("LA MAGIA 2: "+peticion.getFin());
                peticion.setConcepto(concepto);
                peticion.setTipo("Vacaciones");
                dao.addPeticion(peticion);
                System.out.println("HORA: "+Time.valueOf("00:00:00"));
                response.sendRedirect(request.getContextPath()+SOLICITAR_DIAS);
                return;
            } else if(action.equalsIgnoreCase("solicitarVacaciones")){
                System.out.println("YA ETOY");
                forward = SOLICITAR_DIAS;
                Trabajador user = (Trabajador)sesion.getAttribute("usuario");
                String concepto=request.getParameter("concepto");
                System.out.println(concepto);
                int iden = user.getIden();
                java.util.Date inicio = Date.valueOf(request.getParameter("start"));
                System.out.println("INI: "+inicio);
                java.util.Date fin = Date.valueOf(request.getParameter("end"));
                System.out.println("FIN: "+fin);
                System.out.println("CON: "+concepto);
                List<java.util.Date> datesInRange = new ArrayList<>();
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(inicio);
                Calendar endCalendar = new GregorianCalendar();
                endCalendar.setTime(fin);
                while (calendar.before(endCalendar)) {
                    java.util.Date result = calendar.getTime();
                    datesInRange.add(result);
                    calendar.add(Calendar.DATE, 1);
                }
                List<Date> sqlDates = new ArrayList<Date>();
                for(java.util.Date elem:datesInRange){
                    Date newDate = new Date(elem.getTime());
                    sqlDates.add(newDate);
                }
                sqlDates.add(Date.valueOf(request.getParameter("end")));
                for(Date elem:sqlDates){
                    System.out.println(elem);
                    List<Peticion> listaPeticiones = new ArrayList<Peticion>();
                    listaPeticiones = dao.getAllPeticiones();
                    int reqid=0;
                    if (listaPeticiones==null){
                        reqid=1;      
                    }
                    else{
                        int max = 0;
                        for(Peticion pet: listaPeticiones){
                            if(pet.getReqid()>max){
                                max=pet.getReqid();
                            }
                        }
                        reqid=max+1;
                    }
                    Peticion peticion=new Peticion();
                    peticion.setReqid(reqid);
                    peticion.setIden(iden);
                    peticion.setResolucion("Pendiente");
                    peticion.setInicio(Timestamp.valueOf(elem+" 00:00:00"));
                    System.out.println("LA MAGIA: "+peticion.getInicio());
                    peticion.setFin(Timestamp.valueOf(elem+" 23:59:59"));
                    peticion.setConcepto(concepto);
                    peticion.setTipo("Vacaciones");
                    dao.addPeticion(peticion);
                }
                response.sendRedirect(request.getContextPath()+SOLICITAR_DIAS);
                return;
                
            } else {
                Log.log.info("Parametro valor vacio vamos a insertar");
                forward = INSERT_OR_EDIT;
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
