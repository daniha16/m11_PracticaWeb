/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Peticion;
import util.Log;
import util.TrabajadorDao;
import util.TrabajadorProyectoDao;

/**
 *
 * @author danih
 */
public class InformeController extends HttpServlet {

    private static String INICIO = "index.jsp";
    private static String LIST_PETICIONES = "/RRHH/peticiones.jsp";
    private static String INSERT_OR_EDIT = "/RRHH/peticiones.jsp";
    private TrabajadorDao daoT;
    private TrabajadorProyectoDao daoTP;
    public InformeController() {
        super();
        daoT = new TrabajadorDao();
        
        
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
                String tipo = request.getParameter("tipo");
                String periodo = request.getParameter("periodo");
                if(tipo.equals("Empleado")){
                    
                }
            }else {
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
