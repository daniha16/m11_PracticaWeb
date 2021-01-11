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
    private static String INSERT_OR_EDIT = "/.jsp";
    private static String LISTA_PROYECTOS = "/Empleados/poryectos.html";
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
            int proyectoId = Integer.parseInt(request.getParameter("proyectoId"));
            dao.deleteProyecto(proyectoId);
            forward = LISTA_PROYECTOS;
            request.setAttribute("proyectos", dao.getAllProyectos());
        } else if (action.equalsIgnoreCase("edit")) {
            Log.log.info("Parametro valor EDIT");
            forward = INSERT_OR_EDIT;
            int proyectoId = Integer.parseInt(request.getParameter("proyectoId"));
            Proyecto proyecto = dao.getProyectoById(proyectoId);
            request.setAttribute("proyecto", proyecto);
        } else if (action.equalsIgnoreCase("listProyecto")) {
            Log.log.info("Parametro valor LIST");
            forward = LISTA_PROYECTOS;
            request.setAttribute("proyectos", dao.getAllProyectos());
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
        request.setAttribute("proyectos", dao.getAllProyectos());
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
