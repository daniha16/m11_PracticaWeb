/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Trabajador;
import model.Vacaciones;
import util.Log;
import util.VacacionesDao;

/**
 *
 * @author danih
 */
public class CalendarioController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String SHOW_CALENDAR = "/Empleados/calendario.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private static String INICIO = "index.jsp";
    private VacacionesDao dao;
    private Log log;

    public CalendarioController() {
        super();
        dao = new VacacionesDao();
    }
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            if (action.equalsIgnoreCase("calendario")) {
                System.out.println("CALENDARIO");
                List<Vacaciones> vacaciones = new ArrayList<>();
                System.out.println("VACAS");
                vacaciones = dao.getAllVacaciones();
                System.out.println(vacaciones);
                Trabajador user = (Trabajador) sesion.getAttribute("usuario");
                int iden = user.getIden();
                List<String> listaEventos = new ArrayList<String>();
                for(Vacaciones elem:vacaciones){
                    if(elem.getIden_trabajador()==iden){
                        System.out.println("iden1: "+elem.getIden_trabajador()+"/ iden2: "+iden);
                        listaEventos.add("{startDate:\""+elem.getInicio()+"\",endDate:\""+elem.getFin()+"\",summary:\""+elem.getConcepto()+"\"}");
                    }
                }
                for(String elem:listaEventos){
                    System.out.println(elem);
                }
                request.setAttribute("listaEventos", listaEventos);
                RequestDispatcher rd=request.getRequestDispatcher(SHOW_CALENDAR);
                rd.include(request, response);
                return;
            } else {
                Log.log.info("Parametro valor vacio vamos a insertar");
            }
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
            return;
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Log.log.info("Entramos por el doPost");
        HttpSession sesion = request.getSession();
        if(sesion.getAttribute("usuario") == null){
            response.sendRedirect(INICIO);
        }
 
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
