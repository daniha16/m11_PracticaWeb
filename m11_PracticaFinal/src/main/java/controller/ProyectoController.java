/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Proyecto;
import model.Trabajador;
import model.TrabajadorProyecto;
import util.Log;
import util.ProyectoDao;
import util.TrabajadorProyectoDao;

/**
 *
 * @author danih
 */
public class ProyectoController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Empleados/proyecto.jsp";
    private static String PROYECTOS_RRHH = "/RRHH/proyectosRRHH.jsp";
    private static String TIME_PROYECTO = "/Empleados/proyectos.jsp";
    private static String ADD_TIME = "/Empleados/proyectos.jsp";
    private static String LISTA_TPROYECTOS = "/Empleados/proyectos.jsp";
    private static String LISTA_PROYECTOS = "/Empleados/proyectos.jsp";
    private static String INICIO = "index.jsp";
    private ProyectoDao dao;
    private TrabajadorProyectoDao dao2;
    private Log log;

    public ProyectoController() {
        super();
        dao = new ProyectoDao();
        dao2 = new TrabajadorProyectoDao();
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
            System.out.println(sesion.getAttribute("usuario"));
            Trabajador userNombre = (Trabajador)sesion.getAttribute("usuario");
            System.out.println("NOMBRE: "+userNombre.getNombre());
            Log.log.info("Entramos en el doGet");
            String action = request.getParameter("action");
            Log.log.info("Recogemos el parametro action con valor " + action);
            if (action.equalsIgnoreCase("delete")) {
                System.out.println("POS 1");
                Log.log.info("Parametro valor DELETE");
                dao.deleteProyecto("id");
                forward = LISTA_PROYECTOS;
                request.setAttribute("proyecto", dao.getAllProyectos());
            } else if (action.equalsIgnoreCase("edit")) {
                System.out.println("POS 2");
                Log.log.info("Parametro valor EDIT");
                forward = INSERT_OR_EDIT;
                Proyecto proyecto = dao.getProyectoById("id");
                request.setAttribute("proyecto", proyecto);
            } else if (action.equalsIgnoreCase("listProyectosRRHH")) {
                System.out.println("POS 3");
                System.out.println("LISTADO CON PROYECTOS........");
                Log.log.info("Parametro valor LIST");
                forward = PROYECTOS_RRHH;
                System.out.println(dao.getAllProyectos());
                request.setAttribute("listaProyectos", dao.getAllProyectos());
            }else if (action.equalsIgnoreCase("timeProyecto")) {
                System.out.println("POS 4");
                Log.log.info("Parámetro valor GETTIME");
                forward = TIME_PROYECTO;
                request.setAttribute("timeProyecto", dao.getTimeProyecto("id"));
            System.out.println("Hello there 2");
            }else if (action.equalsIgnoreCase("listTrabajadorProyectos")){
                System.out.println("POS 5");
                Log.log.info("Parámetro valor LIST PROYECTOS TRABAJADOR");
                forward = LISTA_TPROYECTOS;
                System.out.println("FLAG1");
                Trabajador user = (Trabajador)sesion.getAttribute("usuario");
                int iden = user.getIden();
                System.out.println(iden);
                List<TrabajadorProyecto> idenList = dao2.getProyectoByIden(iden);
                System.out.println("FLAG2");
                List<Proyecto> listaProyectos = new  ArrayList<Proyecto>();
                for(TrabajadorProyecto elem:idenList){
                    listaProyectos.add(dao.getProyectoById(elem.getId_proyecto()));
                }
                request.setAttribute("proyectosTrabajador", listaProyectos);
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
        else{
    /*          processRequest(request, response); */
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
