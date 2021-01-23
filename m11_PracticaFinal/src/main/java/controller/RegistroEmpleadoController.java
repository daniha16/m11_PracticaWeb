/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Proyecto;
import model.RegistroEmpleado;
import util.Log;
import java.util.Date;
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
            if (action.equalsIgnoreCase("marcaje")) {
                Log.log.info("Parametro valor MARCAJE");
                Date fecha = new Date();
                long tiempo = fecha.getTime();
                Timestamp entrada = new Timestamp(tiempo);
                Trabajador user = (Trabajador)sesion.getAttribute("usuario");
                int iden = user.getIden();
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
