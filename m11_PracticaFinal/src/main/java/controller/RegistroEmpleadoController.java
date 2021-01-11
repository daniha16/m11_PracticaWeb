/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Proyecto;
import model.RegistroEmpleado;
import util.Log;
import util.RegistroEmpleadoDao;

/**
 *
 * @author danih
 */
public class RegistroEmpleadoController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Empleados/registro_diario.html";
     private static String REGISTROS_EMPLEADOS = "/Empleados/registro_diario.html";
    private RegistroEmpleadoDao dao;
    private Log log;

    public RegistroEmpleadoController(){
        super();
        dao = new RegistroEmpleadoDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        Log.log.info("Entramos en el doGet");
        String action = request.getParameter("action");
        Log.log.info("Recogemos el parametro action con valor " + action);
        if (action.equalsIgnoreCase("delete")) {
            Log.log.info("Parametro valor DELETE");
            int proyectoId = Integer.parseInt(request.getParameter("proyectoId"));
            dao.deleteRegistroEmpleado(proyectoId);
            forward = REGISTROS_EMPLEADOS;
            request.setAttribute("proyectos", dao.getAllRegistros());
        } else if (action.equalsIgnoreCase("edit")) {
            Log.log.info("Parametro valor EDIT");
            forward = INSERT_OR_EDIT;
            int proyectoId = Integer.parseInt(request.getParameter("proyectoId"));
            RegistroEmpleado registro = dao.getRegistroByIden(proyectoId);
            request.setAttribute("proyecto", registro);
        } else if (action.equalsIgnoreCase("listProyecto")) {
            Log.log.info("Parametro valor LIST");
            forward = REGISTROS_EMPLEADOS;
            request.setAttribute("proyectos", dao.getAllRegistros());
        } else {
            Log.log.info("Parametro valor vacio vamos a insertar");
            forward = INSERT_OR_EDIT;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        return;
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
