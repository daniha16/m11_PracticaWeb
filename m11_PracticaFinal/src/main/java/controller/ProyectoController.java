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
import util.Log;
import util.ProyectoDao;

/**
 *
 * @author danih
 */
public class ProyectoController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Empleados/proyecto.html";
    private static String LISTA_PROYECTOS = "/Empleados/proyectos.html";
    private static String TIME_PROYECTO = "/Empleados/proyectos.html";
    private static String ADD_TIME = "/Empleados/proyectos.html";
    private ProyectoDao dao;
    private Log log;

    public ProyectoController() {
        super();
        dao = new ProyectoDao();
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
            dao.deleteProyecto("id");
            forward = LISTA_PROYECTOS;
            request.setAttribute("proyecto", dao.getAllProyectos());
        } else if (action.equalsIgnoreCase("edit")) {
            Log.log.info("Parametro valor EDIT");
            forward = INSERT_OR_EDIT;
            Proyecto proyecto = dao.getProyectoById("id");
            request.setAttribute("proyecto", proyecto);
        } else if (action.equalsIgnoreCase("listProyecto")) {
            Log.log.info("Parametro valor LIST");
            forward = LISTA_PROYECTOS;
            request.setAttribute("proyectos", dao.getAllProyectos());
        }else if (action.equalsIgnoreCase("timeProyecto")) {
            Log.log.info("Parámetro valor GETTIME");
            forward = TIME_PROYECTO;
            request.setAttribute("timeProyecto", dao.getTimeProyecto("id"));
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
        proyecto.setId(request.getParameter("id"));
        proyecto.setDescripcion(request.getParameter("descripcion"));                
        proyecto.setCif_empresa(request.getParameter("cif_empresa"));
        proyecto.setId(request.getParameter("id"));
        request.setAttribute("proyecto", dao.getAllProyectos());
        RequestDispatcher view = request.getRequestDispatcher(LISTA_PROYECTOS);            
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
